package com.health.mentalhealth.domain.service;

import com.health.mentalhealth.application.exception.RequestException;
import com.health.mentalhealth.domain.persistence.entity.Food;
import com.health.mentalhealth.domain.persistence.ports.in.IFoodUseCase;
import com.health.mentalhealth.infrastructure.repository.AlarmRepository;
import com.health.mentalhealth.infrastructure.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService implements IFoodUseCase {


    @Autowired
    private FoodRepository foodUseCase;

    @Override
    public Food createFood(Food food) {
        return foodUseCase.save(food);
    }

    @Override
    public void deleteFood(Long id) {
        if(!foodUseCase.existsById(id)) throw new RequestException("404","food doesn't exist :(");
        foodUseCase.deleteById(id);
    }

    @Override
    public Optional<Food> getFoodById(Long id) {
        if(!foodUseCase.existsById(id)) throw new RequestException("404","food doesn't exist :(");
        return foodUseCase.findById(id);
    }

    @Override
    public List<Food> getAllFood() {
        return (List<Food>) foodUseCase.findAll();
    }
}
