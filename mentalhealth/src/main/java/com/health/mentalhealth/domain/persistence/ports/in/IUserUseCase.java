package com.health.mentalhealth.domain.persistence.ports.in;

import com.health.mentalhealth.domain.persistence.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserUseCase {

    //Create user use case
    UserEntity createUser(UserEntity user);

    //Delete user use case
    void deleteUser(Long id);

    //Get user use case
    Optional<UserEntity> getUser(Long id);

    //Get all user use case
    List<UserEntity> getAllUser();
}
