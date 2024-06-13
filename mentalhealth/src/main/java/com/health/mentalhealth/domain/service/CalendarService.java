package com.health.mentalhealth.domain.service;

import com.health.mentalhealth.application.dto.CalendarDTO;
import com.health.mentalhealth.application.exception.EmptyException;
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

    //DTO have a lombok annotation 'builder', is used from send only necessary info

    public CalendarDTO createCalendar(Calendar calendar) {
        YearMonthDay yearMonthDay = new YearMonthDay();
        if(yearMonthDay.validation(calendar.getYear(), calendar.getMonth(), calendar.getDay()))
        calendarDAO.save(calendar);
        return CalendarDTO.builder().year(calendar.getYear()).day(calendar.getDay()).month(calendar.getMonth()).info(calendar.getInfo()).build();
    }


    public void deleteCalendar(Long id) {
        if(calendarDAO.findById(id).isEmpty()) throw new NotFoundedException();
        calendarDAO.deleteById(id);
    }


    public CalendarDTO getCalendar(Long id) {
        if(calendarDAO.findById(id).isEmpty()) throw new NotFoundedException();
        Calendar calendar = calendarDAO.findById(id).get();
        return CalendarDTO.builder().year(calendar.getYear()).month(calendar.getMonth()).day(calendar.getDay()).info(calendar.getInfo()).build();
    }

    //stream, map and toList allow to create a DTO list

    public List<CalendarDTO> getAllCalendar() {
        return calendarDAO.findAll().stream().map(calendar -> CalendarDTO.builder().year(calendar.getYear()).month(calendar.getMonth()).day(calendar.getDay()).info(calendar.getInfo()).build()).toList();
    }

}
