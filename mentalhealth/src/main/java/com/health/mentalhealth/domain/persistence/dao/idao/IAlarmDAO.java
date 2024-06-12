package com.health.mentalhealth.domain.persistence.dao.idao;

import com.health.mentalhealth.domain.persistence.entity.Alarms;

import java.util.List;
import java.util.Optional;

public interface IAlarmDAO {

    Optional<Alarms> findById(long id);

    List<Alarms> findAll();

    void save(Alarms alarms);

    void deleteById(long id);

    Optional<Alarms> findAlarmByDayAndTime(String day, double time);

}
