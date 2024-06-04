package com.health.mentalhealth.domain.service;

import com.health.mentalhealth.domain.persistence.entity.Food;
import com.health.mentalhealth.domain.persistence.ports.in.IFoodUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService implements IFoodUseCase {


    private IFoodUseCase foodUseCase;

    @Override
    public Food createFood(Food food) {
        return foodUseCase.createFood(food);
    }

    @Override
    public void deleteFood(Long id) {
        foodUseCase.deleteFood(id);
    }

    @Override
    public Optional<Food> getFoodById(Long id) {
        return foodUseCase.getFoodById(id);
    }

    @Override
    public List<Food> getAllFood() {
        return foodUseCase.getAllFood();
    }
}
