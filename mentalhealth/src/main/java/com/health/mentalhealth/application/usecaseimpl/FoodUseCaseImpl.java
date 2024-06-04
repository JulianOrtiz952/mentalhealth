package com.health.mentalhealth.application.usecaseimpl;

import com.health.mentalhealth.domain.persistence.entity.Food;
import com.health.mentalhealth.domain.persistence.ports.in.IFoodUseCase;
import com.health.mentalhealth.infrastructure.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FoodUseCaseImpl implements IFoodUseCase {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public Food createFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }

    @Override
    public Optional<Food> getFoodById(Long id) {
        return foodRepository.findById(id);
    }

    @Override
    public List<Food> getAllFood() {
        return (List<Food>) foodRepository.findAll();
    }
}
