package com.health.mentalhealth.infrastructure.controller;

import com.health.mentalhealth.domain.persistence.entity.Calendar;
import com.health.mentalhealth.domain.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCalendarById(@PathVariable Long id){
        return ResponseEntity.ok(calendarService.getCalendar(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllCalendar(){
        return ResponseEntity.ok(calendarService.getAllCalendar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCalendarById(@PathVariable Long id){
        calendarService.deleteCalendar(id);
        return ResponseEntity.ok("");
    }

    @PostMapping
    public ResponseEntity<?> createCalendar(@RequestBody Calendar calendar){
        return ResponseEntity.ok(calendarService.createCalendar(calendar));
    }

}
