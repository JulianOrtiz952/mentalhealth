package com.health.mentalhealth.domain.service;

import com.health.mentalhealth.application.exception.NotFoundedException;
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
        if(alarmRepository.findAlarmByDayAndTime(alarms.getDay(), alarms.getTime()).isPresent()) throw new RequestException("401", "alarm already exist");
        return alarmRepository.save(alarms);
    }

    @Override
    public void deleteAlarmById(Long id) {
        // Implementación del método
        if(!alarmRepository.existsById(id)) throw new NotFoundedException();
        alarmRepository.deleteById(id);
    }

    @Override
    public Optional<Alarms> getAlarmById(Long id) {
        // Implementación del método
        if(!alarmRepository.existsById(id)) throw new NotFoundedException();
        return alarmRepository.findById(id);
    }

    @Override
    public List<Alarms> getAllAlarms() {
        // Implementación del método
        return (List<Alarms>) alarmRepository.findAll();
    }
}
