package com.health.mentalhealth.domain.persistence.dao.impl;

import com.health.mentalhealth.domain.persistence.dao.idao.ICalendarDAO;
import com.health.mentalhealth.domain.persistence.entity.Calendar;
import com.health.mentalhealth.infrastructure.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CalendarDAOImpl implements ICalendarDAO {

    @Autowired
    private CalendarRepository calendarRepository;

    //repository method implementation to dao interface

    @Override
    public Optional<Calendar> findById(long id) {
        return calendarRepository.findById(id);
    }

    @Override
    public List<Calendar> findAll() {
        return (List<Calendar>) calendarRepository.findAll();
    }

    @Override
    public void save(Calendar calendar) {
        calendarRepository.save(calendar);
    }

    @Override
    public void deleteById(long id) {
        calendarRepository.deleteById(id);
    }
}
