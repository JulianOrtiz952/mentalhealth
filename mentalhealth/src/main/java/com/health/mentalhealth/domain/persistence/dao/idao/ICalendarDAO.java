package com.health.mentalhealth.domain.persistence.dao.idao;

import com.health.mentalhealth.domain.persistence.entity.Calendar;

import java.util.List;
import java.util.Optional;

public interface ICalendarDAO {

    Optional<Calendar> findById(long id);

    List<Calendar> findAll();

    void save(Calendar calendar);

    void deleteById(long id);
}
