package com.health.mentalhealth.domain.persistence.ports.out;

import com.health.mentalhealth.domain.persistence.entity.Alarms;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@PersistenceContext
public interface IAlarmsRepositoryPort {

    Alarms createAlarms(Alarms alarms);

    Optional<Alarms> findById(Long id);

    List<Alarms> findALlAlarms();

    void deleteById(Long id);

}
