package com.health.mentalhealth.domain.persistence.dao.idao;

import com.health.mentalhealth.domain.persistence.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {

    //interface data access object with methods

    Optional<UserEntity> findById(long id);

    List<UserEntity> findAll();

    void save(UserEntity user);

    void deleteById(long id);

    //method with repository query

    Optional<UserEntity> findUserByEmail(String email);


}
