package com.health.mentalhealth.domain.persistence.dao.impl;

import com.health.mentalhealth.domain.persistence.dao.idao.IAlarmDAO;
import com.health.mentalhealth.domain.persistence.entity.Alarms;
import com.health.mentalhealth.infrastructure.repository.AlarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AlarmDAOImpl implements IAlarmDAO {

    @Autowired
    private AlarmRepository alarmRepository;

    //repository method implementation to dao interface

    @Override
    public Optional<Alarms> findById(long id) {
        return alarmRepository.findById(id);
    }

    @Override
    public List<Alarms> findAll() {
        return (List<Alarms>) alarmRepository.findAll();
    }

    @Override
    public void save(Alarms alarms) {
        alarmRepository.save(alarms);
    }

    @Override
    public void deleteById(long id) {
        alarmRepository.deleteById(id);
    }

    @Override
    public Optional<Alarms> findAlarmByDayAndTime(int day, double time) {
        return alarmRepository.findAlarmByDayAndTime(day, time);
    }
}
