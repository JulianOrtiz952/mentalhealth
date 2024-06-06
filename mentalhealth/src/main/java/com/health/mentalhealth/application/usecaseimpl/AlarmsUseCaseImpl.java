package com.health.mentalhealth.application.usecaseimpl;

import com.health.mentalhealth.domain.persistence.entity.Alarms;
import com.health.mentalhealth.domain.persistence.ports.in.IAlarmUseCase;
import com.health.mentalhealth.domain.persistence.ports.out.IAlarmsRepositoryPort;
import com.health.mentalhealth.infrastructure.repository.AlarmRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


public class AlarmsUseCaseImpl implements IAlarmUseCase {

    @Autowired
    private  IAlarmsRepositoryPort alarmRepository;

    @Override
    public Alarms createAlarm(Alarms alarms) {
        return alarmRepository.createAlarms(alarms);
    }

    @Override
    public void deleteAlarmById(Long id) {
        alarmRepository.deleteById(id);
    }

    @Override
    public Optional<Alarms> getAlarmById(Long id) {
        return alarmRepository.findById(id);
    }

    @Override
    public List<Alarms> getAllAlarms() {
        return (List<Alarms>) alarmRepository.findALlAlarms();
    }
}