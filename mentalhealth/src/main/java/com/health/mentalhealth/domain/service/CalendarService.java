package com.health.mentalhealth.domain.service;

import com.health.mentalhealth.application.exception.RequestException;
import com.health.mentalhealth.domain.persistence.entity.Calendar;
import com.health.mentalhealth.domain.persistence.ports.in.ICalendarUseCase;
import com.health.mentalhealth.infrastructure.repository.CalendarRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarService implements ICalendarUseCase {


    @Autowired
    private CalendarRepository calendarUseCase;

    @Override
    public Calendar createCalendar(Calendar calendar) {
        return calendarUseCase.save(calendar);
    }

    @Override
    public void deleteCalendar(Long id) {
        if(!calendarUseCase.existsById(id)) throw new RequestException("404","calendar doesn't exist :(");
        calendarUseCase.deleteById(id);
    }

    @Override
    public Optional<Calendar> getCalendar(Long id) {
        if(!calendarUseCase.existsById(id)) throw new RequestException("404","calendar doesn't exist :(");
        return calendarUseCase.findById(id);
    }

    @Override
    public List<Calendar> getAllCalendar() {
        return (List<Calendar>) calendarUseCase.findAll();
    }
}
