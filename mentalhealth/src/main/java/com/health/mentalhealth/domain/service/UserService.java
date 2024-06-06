package com.health.mentalhealth.domain.service;
import com.health.mentalhealth.domain.persistence.entity.UserEntity;
import com.health.mentalhealth.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    public Optional<UserEntity> getUser(Long id) {
        return userRepository.findById(id);
    }


    public List<UserEntity> getAllUser() {
        return (List<UserEntity>) userRepository.findAll();
    }
}
