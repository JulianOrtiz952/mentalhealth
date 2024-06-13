package com.health.mentalhealth.domain.persistence.dao.idao;

import com.health.mentalhealth.domain.persistence.entity.Routines;

import java.util.List;
import java.util.Optional;

public interface IRoutinesDAO {

    //interface data access object with methods

    Optional<Routines> findById(long id);

    List<Routines> findAll();

    void save(Routines routines);

    void deleteById(long id);

    //methods with repository Query

    List<Routines> findRoutinesByName(String name);

    List<String> findAllRoutinesName();

    Optional<Routines> findByDayAndHour(String day, double hour);

}
