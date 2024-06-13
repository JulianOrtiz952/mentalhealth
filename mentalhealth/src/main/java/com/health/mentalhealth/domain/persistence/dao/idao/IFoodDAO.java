package com.health.mentalhealth.domain.persistence.dao.idao;

import com.health.mentalhealth.domain.persistence.entity.Calendar;
import com.health.mentalhealth.domain.persistence.entity.Food;

import java.util.List;
import java.util.Optional;

public interface IFoodDAO {

    //interface data access object with methods

    Optional<Food> findById(long id);

    List<Food> findAll();

    Food save(Food food);

    void deleteById(long id);

}
