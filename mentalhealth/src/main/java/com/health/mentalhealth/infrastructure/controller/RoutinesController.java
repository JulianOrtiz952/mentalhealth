package com.health.mentalhealth.infrastructure.controller;

import com.health.mentalhealth.domain.persistence.entity.Routines;
import com.health.mentalhealth.domain.service.RoutinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/routines")
public class RoutinesController {

    @Autowired
    private RoutinesService routinesService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoutinesById(@PathVariable Long id){
        return ResponseEntity.ok(routinesService.getRoutinesById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllRoutines(){
        return ResponseEntity.ok(routinesService.getAllRoutines());
    }

    @GetMapping("/name")
    public ResponseEntity<?> getRoutineByName(@RequestBody String name){
        return ResponseEntity.ok(routinesService.findByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        routinesService.deleteRoutines(id);
        return ResponseEntity.ok("deleted");
    }

    @PostMapping
    public ResponseEntity<?> createRoutine(@RequestBody Routines routines){
        return ResponseEntity.ok(routinesService.createRoutines(routines));
    }



}
