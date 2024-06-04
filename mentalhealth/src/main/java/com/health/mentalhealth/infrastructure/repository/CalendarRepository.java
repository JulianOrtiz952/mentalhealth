package com.health.mentalhealth.infrastructure.repository;

import com.health.mentalhealth.domain.persistence.entity.Calendar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends CrudRepository<Calendar, Long> {
}
