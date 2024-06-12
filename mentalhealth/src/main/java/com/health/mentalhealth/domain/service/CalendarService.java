package com.health.mentalhealth.domain.service;

import com.health.mentalhealth.application.exception.NotFoundedException;
import com.health.mentalhealth.domain.persistence.dao.idao.ICalendarDAO;
import com.health.mentalhealth.domain.persistence.entity.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarService {


    @Autowired
    private ICalendarDAO calendarDAO;


    public Calendar createCalendar(Calendar calendar) {
        calendarDAO.save(calendar);
        return calendar;
    }


    public void deleteCalendar(Long id) {
        if(calendarDAO.findById(id).isEmpty()) throw new NotFoundedException();
        calendarDAO.deleteById(id);
    }


    public Optional<Calendar> getCalendar(Long id) {
        if(calendarDAO.findById(id).isEmpty()) throw new NotFoundedException();
        return calendarDAO.findById(id);
    }


    public List<Calendar> getAllCalendar() {
        return (List<Calendar>) calendarDAO.findAll();
    }
}
