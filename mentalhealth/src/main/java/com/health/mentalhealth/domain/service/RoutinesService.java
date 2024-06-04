package com.health.mentalhealth.domain.service;

import com.health.mentalhealth.domain.persistence.entity.Routines;
import com.health.mentalhealth.domain.persistence.ports.in.IRoutinesUseCase;
import com.health.mentalhealth.infrastructure.repository.RoutinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoutinesService implements IRoutinesUseCase {

    @Autowired
    private IRoutinesUseCase routinesUseCase;


    @Override
    public Routines createRoutines(Routines routines) {
        return routinesUseCase.createRoutines(routines);
    }

    @Override
    public void deleteRoutines(Long id) {
        routinesUseCase.deleteRoutines(id);
    }

    @Override
    public Optional<Routines> getRoutinesById(Long id) {
        return routinesUseCase.getRoutinesById(id);
    }

    @Override
    public List<Routines> getAllRoutines() {
        return routinesUseCase.getAllRoutines();
    }
}
