package com.health.mentalhealth.domain.service;

import com.health.mentalhealth.application.exception.NotFoundedException;
import com.health.mentalhealth.application.exception.RequestException;
import com.health.mentalhealth.domain.persistence.dao.idao.IAlarmDAO;
import com.health.mentalhealth.domain.persistence.entity.Alarms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlarmService {

    @Autowired
    private IAlarmDAO alarmDAO;


    public Alarms createAlarm(Alarms alarms) {
        // Implementación del método
        if(alarmDAO.findAlarmByDayAndTime(alarms.getDay(), alarms.getTime()).isPresent()) throw new RequestException("401", "alarm already exist");
        alarmDAO.save(alarms);
        return alarms;
    }


    public void deleteAlarmById(Long id) {
        // Implementación del método
        if(alarmDAO.findById(id).isEmpty()) throw new NotFoundedException();
        alarmDAO.deleteById(id);
    }


    public Optional<Alarms> getAlarmById(Long id) {
        // Implementación del método
        if(alarmDAO.findById(id).isEmpty()) throw new NotFoundedException();
        return alarmDAO.findById(id);
    }


    public List<Alarms> getAllAlarms() {
        return (List<Alarms>) alarmDAO.findAll();
    }
}
