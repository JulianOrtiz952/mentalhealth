package com.health.mentalhealth.application.usecaseimpl;

import com.health.mentalhealth.domain.persistence.entity.Routines;
import com.health.mentalhealth.domain.persistence.ports.in.IRoutinesUseCase;
import com.health.mentalhealth.infrastructure.repository.RoutinesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RoutinesUseCaseImpl implements IRoutinesUseCase {

    @Autowired
    private RoutinesRepository routinesRepository;

    @Override
    public Routines createRoutines(Routines routines) {
        return routinesRepository.save(routines);
    }

    @Override
    public void deleteRoutines(Long id) {
        routinesRepository.deleteById(id);
    }

    @Override
    public Optional<Routines> getRoutinesById(Long id) {
        return routinesRepository.findById(id);
    }

    @Override
    public List<Routines> getAllRoutines() {
        return (List<Routines>)routinesRepository.findAll();
    }
}
