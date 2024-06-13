package com.health.mentalhealth.domain.persistence.dao.idao;

import com.health.mentalhealth.domain.persistence.entity.Alarms;

import java.util.List;
import java.util.Optional;

public interface IAlarmDAO {

    //interface data access object with methods

    Optional<Alarms> findById(long id);

    List<Alarms> findAll();

    void save(Alarms alarms);

    void deleteById(long id);

    //method with repository query

    Optional<Alarms> findAlarmByDayAndTime(int day, double time);

}
