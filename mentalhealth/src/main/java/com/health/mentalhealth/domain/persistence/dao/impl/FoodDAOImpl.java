package com.health.mentalhealth.domain.persistence.dao.impl;

import com.health.mentalhealth.domain.persistence.dao.idao.IFoodDAO;
import com.health.mentalhealth.domain.persistence.entity.Food;
import com.health.mentalhealth.infrastructure.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FoodDAOImpl implements IFoodDAO {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public Optional<Food> findById(long id) {
        return foodRepository.findById(id);
    }

    @Override
    public List<Food> findAll() {
        return (List<Food>) foodRepository.findAll();
    }

    @Override
    public Food save(Food food) {
        foodRepository.save(food);
        return food;
    }

    @Override
    public void deleteById(long id) {
        foodRepository.deleteById(id);
    }
}
