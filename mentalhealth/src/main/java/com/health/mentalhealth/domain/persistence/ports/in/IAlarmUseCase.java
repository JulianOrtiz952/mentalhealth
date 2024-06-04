package com.health.mentalhealth.domain.persistence.ports.in;

import com.health.mentalhealth.domain.persistence.entity.Alarms;

import java.util.List;
import java.util.Optional;

public interface IAlarmUseCase {

    //Api method use case

    Alarms createAlarm(Alarms alarms);

    void deleteAlarmById(Long id);

    Optional<Alarms> getAlarmById(Long id);

    List<Alarms> getAllAlarms();
}
