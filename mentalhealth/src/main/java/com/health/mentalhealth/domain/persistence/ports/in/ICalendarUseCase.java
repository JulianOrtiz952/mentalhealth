package com.health.mentalhealth.domain.persistence.ports.in;

import com.health.mentalhealth.domain.persistence.entity.Calendar;

import java.util.List;
import java.util.Optional;

public interface ICalendarUseCase {

    Calendar createCalendar(Calendar calendar);
    void deleteCalendar(Long id);
    Optional<Calendar> getCalendar(Long id);
    List<Calendar> getAllCalendar();

}
