package com.health.mentalhealth.infrastructure.repository;

import com.health.mentalhealth.domain.persistence.entity.Routines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoutinesRepository extends JpaRepository<Routines, Long> {

    @Query("SELECT r FROM Routines r WHERE r.name = :name")
    List<Routines> findRoutinesByName(@Param("name") String name);

    @Query("SELECT r FROM Routines r WHERE r.day = :day AND r.hour = :hour")
    Optional<Routines> findByDayAndHour(@Param("day") String name, @Param("hour") double hour);

    @Query("SELECT r.name FROM Routines r")
    List<String> findAllRoutinesName();
}
