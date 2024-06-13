package com.health.mentalhealth.domain.persistence.dao.impl;

import com.health.mentalhealth.domain.persistence.dao.idao.IRoutinesDAO;
import com.health.mentalhealth.domain.persistence.entity.Routines;
import com.health.mentalhealth.infrastructure.repository.RoutinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RoutinesDAOImpl implements IRoutinesDAO {

    @Autowired
    private RoutinesRepository routinesRepository;

    //repository method implementation to dao interface

    @Override
    public Optional<Routines> findById(long id) {
        return routinesRepository.findById(id);
    }

    @Override
    public List<Routines> findAll() {
        return (List<Routines>) routinesRepository.findAll();
    }

    @Override
    public void save(Routines routines) {
        routinesRepository.save(routines);
    }

    @Override
    public void deleteById(long id) {
        routinesRepository.deleteById(id);
    }

    @Override
    public List<Routines> findRoutinesByName(String name) {
        return routinesRepository.findRoutinesByName(name);
    }

    @Override
    public List<String> findAllRoutinesName() {
        return routinesRepository.findAllRoutinesName();
    }

    @Override
    public Optional<Routines> findByDayAndHour(String day, double hour) {
        return routinesRepository.findByDayAndHour(day, hour);
    }
}
