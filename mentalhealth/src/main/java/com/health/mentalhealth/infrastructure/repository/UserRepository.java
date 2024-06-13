package com.health.mentalhealth.infrastructure.repository;

import com.health.mentalhealth.domain.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Query("SELECT r FROM UserEntity r WHERE r.email = :email")
    Optional<UserEntity> findUserByEmail(@Param("email") String email);

}
