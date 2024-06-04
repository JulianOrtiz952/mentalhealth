package com.health.mentalhealth.infrastructure.repository;

import com.health.mentalhealth.domain.persistence.entity.Alarms;
import org.springframework.data.repository.CrudRepository;

public interface AlarmRepository extends CrudRepository<Alarms, Long> {
}
