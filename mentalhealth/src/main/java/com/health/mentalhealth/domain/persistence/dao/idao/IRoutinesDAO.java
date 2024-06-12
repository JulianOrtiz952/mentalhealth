package com.health.mentalhealth.domain.persistence.dao.idao;

import com.health.mentalhealth.domain.persistence.entity.Routines;

import java.util.List;
import java.util.Optional;

public interface IRoutinesDAO {

    Optional<Routines> findById(long id);

    List<Routines> findAll();

    void save(Routines routines);

    void deleteById(long id);

    List<Routines> findRoutinesByName(String name);

    List<String> findAllRoutinesName();

    Optional<Routines> findByDayAndHour(String day, double hour);

}
