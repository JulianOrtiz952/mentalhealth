package com.health.mentalhealth.infrastructure.controller;

import com.health.mentalhealth.domain.persistence.entity.Alarms;
import com.health.mentalhealth.domain.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alarm")
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAlarmById(@PathVariable Long id){
        return ResponseEntity.ok(alarmService.getAlarmById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllAlarms(){
        return ResponseEntity.ok(alarmService.getAllAlarms());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlarmById(@PathVariable Long id){
        alarmService.deleteAlarmById(id);
        return ResponseEntity.ok("");
    }

    @PostMapping
    public ResponseEntity<?> createAlarm(@RequestBody Alarms alarms){
        return ResponseEntity.ok(alarmService.createAlarm(alarms));
    }

}
