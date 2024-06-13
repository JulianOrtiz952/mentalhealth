package com.health.mentalhealth.domain.service;

import com.health.mentalhealth.application.dto.RoutineDTO;
import com.health.mentalhealth.application.exception.NotFoundedException;
import com.health.mentalhealth.application.exception.RequestException;
import com.health.mentalhealth.domain.persistence.dao.idao.IRoutinesDAO;
import com.health.mentalhealth.domain.persistence.entity.Routines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutinesService  {

    @Autowired
    private IRoutinesDAO routinesDAO;

    //DTO have a lombok annotation 'builder', is used from send only necessary info

    public RoutineDTO createRoutines(Routines routines) {
        if(routinesDAO.findByDayAndHour(routines.getDay(), routines.getHour()).isPresent()) throw new RequestException("401","routine already exist");
        routinesDAO.save(routines);
        return RoutineDTO.builder().id(routines.getId()).name(routines.getName()).day(routines.getDay()).hour(routines.getHour()).info(routines.getInfo()).duration(routines.getDuration()).build();
    }


    public void deleteRoutines(Long id) {
        if(routinesDAO.findById(id).isEmpty()) throw new NotFoundedException();
        routinesDAO.deleteById(id);
    }


    public RoutineDTO getRoutinesById(Long id) {
        if(routinesDAO.findById(id).isEmpty()) throw new NotFoundedException();
        Routines routines = routinesDAO.findById(id).get();
        return RoutineDTO.builder().id(routines.getId()).name(routines.getName()).day(routines.getDay()).hour(routines.getHour()).info(routines.getInfo()).duration(routines.getDuration()).build();
    }

    //stream, map and toList allow to create a DTO list

    public List<RoutineDTO> getAllRoutines() {
        return routinesDAO.findAll().stream().map(routines -> RoutineDTO.builder().id(routines.getId()).name(routines.getName()).day(routines.getDay()).hour(routines.getHour()).info(routines.getInfo()).duration(routines.getDuration()).build()).toList();
    }

    //method find all routines by name and return DTO

    public List<RoutineDTO> findByName(String name){
        if(routinesDAO.findRoutinesByName(name).isEmpty()) throw new NotFoundedException("Routine with name: '" + name + "' doesn't exist");
        return routinesDAO.findRoutinesByName(name).stream().map(routines -> RoutineDTO.builder().name(routines.getName()).duration(routines.getDuration()).info(routines.getInfo()).day(routines.getDay()).hour(routines.getHour()).build()).toList();
    }

    //method find all routines by name and return a string list

    public List<String> findAllRoutinesName(){
        return routinesDAO.findAllRoutinesName();
    }
}
