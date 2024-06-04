package com.health.mentalhealth.application.usecaseimpl;

import com.health.mentalhealth.domain.persistence.entity.Alarms;
import com.health.mentalhealth.domain.persistence.ports.in.IAlarmUseCase;
import com.health.mentalhealth.infrastructure.repository.AlarmRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AlarmsUseCaseImpl implements IAlarmUseCase {

    @Autowired
    private AlarmRepository alarmRepository;

    @Override
    public Alarms createAlarm(Alarms alarms) {
        return alarmRepository.save(alarms);
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
        return (List<Alarms>) alarmRepository.findAll();
    }
}
