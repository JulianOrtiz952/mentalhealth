package com.health.mentalhealth.domain.persistence.ports.in;

import com.health.mentalhealth.domain.persistence.entity.Routines;

import java.util.List;
import java.util.Optional;

public interface IRoutinesUseCase {

    Routines createRoutines(Routines routines);
    void deleteRoutines(Long id);
    Optional<Routines> getRoutinesById(Long id);
    List<Routines> getAllRoutines();

}
