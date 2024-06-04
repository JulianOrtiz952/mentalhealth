package com.health.mentalhealth.application.usecaseimpl;

import com.health.mentalhealth.domain.persistence.entity.UserEntity;
import com.health.mentalhealth.domain.persistence.ports.in.IUserUseCase;
import com.health.mentalhealth.infrastructure.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserUseCaseImpl implements IUserUseCase {

    //repository
    private UserRepository userRepository;

    //Find user use case implementation
    public Optional<UserEntity> findUserById(long id){
        return userRepository.findById(id);
    }

    //Create user use case implementation
    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    //Delete user use case implementation
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    //Get user use case implementation
    @Override
    public Optional<UserEntity> getUser(Long id) {
        return findUserById(id);
    }

    //Get all user use case implementation
    @Override
    public List<UserEntity> getAllUser() {
        return (List<UserEntity>)userRepository.findAll();
    }
}
