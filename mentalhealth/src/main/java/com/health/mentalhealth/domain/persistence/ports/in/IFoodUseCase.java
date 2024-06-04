package com.health.mentalhealth.domain.persistence.ports.in;

import com.health.mentalhealth.domain.persistence.entity.Food;

import java.util.List;
import java.util.Optional;

public interface IFoodUseCase {

    Food createFood(Food food);
    void deleteFood(Long id);

    Optional<Food> getFoodById(Long id);
    List<Food> getAllFood();

}
