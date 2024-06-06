package com.health.mentalhealth.domain.service;
import com.health.mentalhealth.application.exception.NotFoundedException;
import com.health.mentalhealth.application.exception.RequestException;
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
        if(user.getEmail().isEmpty() ||  user.getPassword().isEmpty()) throw new RequestException("401", "email or password required");
        return userRepository.save(user);
    }


    public void deleteUser(Long id) {
        if(!userRepository.existsById(id)) throw new NotFoundedException();
        userRepository.deleteById(id);
    }


    public Optional<UserEntity> getUser(Long id) {
        if(!userRepository.existsById(id)) throw new NotFoundedException();
        return userRepository.findById(id);
    }


    public List<UserEntity> getAllUser() {
        return (List<UserEntity>) userRepository.findAll();
    }

    public UserEntity updateUser(UserEntity user){
        if(!userRepository.existsById(user.getId())) throw new NotFoundedException();
        else return userRepository.save(user);
    }
}
