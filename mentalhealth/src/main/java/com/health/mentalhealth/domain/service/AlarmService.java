package com.health.mentalhealth.domain.service;

import com.health.mentalhealth.application.dto.AlarmDTO;
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

    //DTO have a lombok annotation 'builder', is used from send only necessary info

    public AlarmDTO createAlarm(Alarms alarms) {
        if(alarmDAO.findAlarmByDayAndTime(alarms.getDay(), alarms.getTime()).isPresent()) throw new RequestException("401", "alarm already exist");
        alarmDAO.save(alarms);
        return AlarmDTO.builder().name(alarms.getName()).day(alarms.getDay()).time(alarms.getTime()).build();
    }


    public void deleteAlarmById(Long id) {
        if(alarmDAO.findById(id).isEmpty()) throw new NotFoundedException();
        alarmDAO.deleteById(id);
    }


    public AlarmDTO getAlarmById(Long id) {
        if(alarmDAO.findById(id).isEmpty()) throw new NotFoundedException();
        Alarms alarm = alarmDAO.findById(id).get();
        return AlarmDTO.builder().name(alarm.getName()).day(alarm.getDay()).time(alarm.getTime()).build();
    }

    //stream, map and toList allow to create a DTO list

    public List<AlarmDTO> getAllAlarms() {
        return alarmDAO.findAll().stream().map(alarms -> AlarmDTO.builder().name(alarms.getName()).day(alarms.getDay()).time(alarms.getTime()).build()).toList();
    }
}
