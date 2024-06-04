package com.health.mentalhealth.domain.persistence.ports.out;

import com.health.mentalhealth.domain.persistence.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserRepositoryPort {

    //Create user port out
    UserEntity createUser(UserEntity user);

    //Delete user port out
    boolean deleteUser(Long id);

    //Get user port out
    Optional<UserEntity> getUser(Long id);

    //Get all user port out
    List<UserEntity> getAllUser();

    //Update User port out
    boolean updateUser(UserEntity user);

}
