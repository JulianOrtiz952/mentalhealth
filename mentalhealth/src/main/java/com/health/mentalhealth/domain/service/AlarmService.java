package com.health.mentalhealth.domain.service;

import com.health.mentalhealth.domain.persistence.entity.Alarms;
import com.health.mentalhealth.domain.persistence.ports.in.IAlarmUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlarmService implements IAlarmUseCase {

    private IAlarmUseCase alarmUseCase;

    @Override
    public Alarms createAlarm(Alarms alarms) {
        return alarmUseCase.createAlarm(alarms);
    }

    @Override
    public void deleteAlarmById(Long id) {
        alarmUseCase.deleteAlarmById(id);
    }

    @Override
    public Optional<Alarms> getAlarmById(Long id) {
        return alarmUseCase.getAlarmById(id);
    }

    @Override
    public List<Alarms> getAllAlarms() {
        return alarmUseCase.getAllAlarms();
    }
}
