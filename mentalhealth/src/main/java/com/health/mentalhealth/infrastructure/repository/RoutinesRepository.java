package com.health.mentalhealth.infrastructure.repository;

import com.health.mentalhealth.domain.persistence.entity.Routines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutinesRepository extends JpaRepository<Routines, Long> {

    @Query("SELECT r FROM Routines r WHERE r.name = :name")
    List<Routines> findRoutinesByName(@Param("name") String name);

}
