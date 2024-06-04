package com.health.mentalhealth.application.usecaseimpl;

import com.health.mentalhealth.domain.persistence.entity.Calendar;
import com.health.mentalhealth.domain.persistence.ports.in.ICalendarUseCase;
import com.health.mentalhealth.infrastructure.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CalendarUseCaseImpl implements ICalendarUseCase {

    @Autowired
    private CalendarRepository calendarRepository;

    @Override
    public Calendar createCalendar(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    @Override
    public void deleteCalendar(Long id) {
        calendarRepository.deleteById(id);
    }

    @Override
    public Optional<Calendar> getCalendar(Long id) {
        return calendarRepository.findById(id);
    }

    @Override
    public List<Calendar> getAllCalendar() {
        return (List<Calendar>) calendarRepository.findAll();
    }
}
