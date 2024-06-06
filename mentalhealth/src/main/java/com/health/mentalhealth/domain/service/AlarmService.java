package com.health.mentalhealth.domain.service;

import com.health.mentalhealth.application.exception.RequestException;
import com.health.mentalhealth.application.usecaseimpl.AlarmsUseCaseImpl;
import com.health.mentalhealth.domain.persistence.entity.Alarms;
import com.health.mentalhealth.domain.persistence.ports.in.IAlarmUseCase;
import com.health.mentalhealth.infrastructure.repository.AlarmRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlarmService implements IAlarmUseCase {

    @Autowired
    private AlarmRepository alarmRepository;

    @Override
    public Alarms createAlarm(Alarms alarms) {
        // Implementación del método
        return alarmRepository.save(alarms);
    }

    @Override
    public void deleteAlarmById(Long id) {
        // Implementación del método
        if(!alarmRepository.existsById(id)) throw new RequestException("404","alarm doesn't exist :(");
        alarmRepository.deleteById(id);
    }

    @Override
    public Optional<Alarms> getAlarmById(Long id) {
        // Implementación del método
        if(!alarmRepository.existsById(id)) throw new RequestException("404","alarm doesn't exist :(");
        return alarmRepository.findById(id);
    }

    @Override
    public List<Alarms> getAllAlarms() {
        // Implementación del método
        return (List<Alarms>) alarmRepository.findAll();
    }
}
