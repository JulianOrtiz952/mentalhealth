package com.health.mentalhealth.domain.service;
import com.health.mentalhealth.domain.persistence.entity.UserEntity;
import com.health.mentalhealth.domain.persistence.ports.in.IUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserUseCase {

    @Autowired
    private IUserUseCase userUseCase;

    @Override
    public UserEntity createUser(UserEntity user) {
        return userUseCase.createUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userUseCase.deleteUser(id);
    }

    @Override
    public Optional<UserEntity> getUser(Long id) {
        return userUseCase.getUser(id);
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userUseCase.getAllUser();
    }
}
