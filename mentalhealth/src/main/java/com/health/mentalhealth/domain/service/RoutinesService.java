package com.health.mentalhealth.domain.service;

import com.health.mentalhealth.application.exception.RequestException;
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
    private RoutinesRepository routinesUseCase;

    @Override
    public Routines createRoutines(Routines routines) {
        return routinesUseCase.save(routines);
    }

    @Override
    public void deleteRoutines(Long id) {
        if(!routinesUseCase.existsById(id)) throw new RequestException("404","routine doesn't exist :(");
        routinesUseCase.deleteById(id);
    }

    @Override
    public Optional<Routines> getRoutinesById(Long id) {
        if(!routinesUseCase.existsById(id)) throw new RequestException("404","routine doesn't exist :(");
        return routinesUseCase.findById(id);
    }

    @Override
    public List<Routines> getAllRoutines() {
        return (List<Routines>) routinesUseCase.findAll();
    }

    public List<Routines> findByName(String name){
        if(routinesUseCase.findRoutinesByName(name)==null) throw new RequestException("404","routine with name: " + name+ " doesn't exist :(");
        return (List<Routines>) routinesUseCase.findRoutinesByName(name);
    }
}
