package com.health.mentalhealth.domain.service;

import com.health.mentalhealth.application.exception.NotFoundedException;
import com.health.mentalhealth.application.exception.RequestException;
import com.health.mentalhealth.domain.persistence.dao.idao.IRoutinesDAO;
import com.health.mentalhealth.domain.persistence.entity.Routines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoutinesService  {

    @Autowired
    private IRoutinesDAO routinesDAO;


    public Routines createRoutines(Routines routines) {
        List<Routines> routinesList= routinesDAO.findAll();
        if(routinesDAO.findByDayAndHour(routines.getDay(), routines.getHour()).isPresent()) throw new RequestException("401","routine already exist");
        routinesDAO.save(routines);
        return routines;
    }


    public void deleteRoutines(Long id) {
        if(routinesDAO.findById(id).isEmpty()) throw new NotFoundedException();
        routinesDAO.deleteById(id);
    }


    public Optional<Routines> getRoutinesById(Long id) {
        if(routinesDAO.findById(id).isEmpty()) throw new NotFoundedException();
        return routinesDAO.findById(id);
    }


    public List<Routines> getAllRoutines() {
        return (List<Routines>) routinesDAO.findAll();
    }

    public List<Routines> findByName(String name){
        if(routinesDAO.findRoutinesByName(name).isEmpty()) throw new NotFoundedException("Routine with name: '" + name + "' doesn't exist");
        return (List<Routines>) routinesDAO.findRoutinesByName(name);
    }

    public List<String> findAllRoutinesName(){
        return routinesDAO.findAllRoutinesName();
    }
}
