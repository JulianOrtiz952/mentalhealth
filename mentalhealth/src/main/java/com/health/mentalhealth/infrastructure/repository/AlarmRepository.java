package com.health.mentalhealth.infrastructure.repository;

import com.health.mentalhealth.domain.persistence.entity.Alarms;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AlarmRepository extends CrudRepository<Alarms, Long> {

    @Query("SELECT r FROM Alarms r WHERE r.day = :day AND r.time = :time")
    Optional<Alarms> findAlarmByDayAndTime(@Param("day") String day, @Param("time") double time);

}
