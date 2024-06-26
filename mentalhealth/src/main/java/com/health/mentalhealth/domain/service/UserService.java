package com.health.mentalhealth.domain.service;
import com.health.mentalhealth.application.dto.UserDTO;
import com.health.mentalhealth.application.exception.EmailAlreadyExistException;
import com.health.mentalhealth.application.exception.NotFoundedException;
import com.health.mentalhealth.application.exception.RequestException;
import com.health.mentalhealth.domain.persistence.dao.idao.IUserDAO;
import com.health.mentalhealth.domain.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserDAO userDAO;

    //DTO have a lombok annotation 'builder', is used from send only necessary info

    //signup method
    public UserDTO createUser(UserEntity user) {
        //is necessary email and password lmao
        if(user.getEmail().isEmpty() ||  user.getPassword().isEmpty()) throw new RequestException("401", "email or password required");
        //two user can't have the same email
        if(userDAO.findUserByEmail(user.getEmail()).isPresent()) throw new EmailAlreadyExistException("email is linked in another account");
        userDAO.save(user);
        return UserDTO.builder().id(user.getId()).name(user.getName()).phone(user.getPhone()).email(user.getEmail()).build();
    }

    public void deleteUser(Long id) {
        if(userDAO.findById(id).isEmpty()) throw new NotFoundedException();
        userDAO.deleteById(id);
    }

    public UserDTO getUser(Long id) {
        if(userDAO.findById(id).isEmpty()) throw new NotFoundedException();
        UserEntity user = userDAO.findById(id).get();
        return UserDTO.builder().id(user.getId()).name(user.getName()).build();
    }

    //stream, map and toList allow to create a DTO list
    public List<UserDTO> getAllUser() {
        return userDAO.findAll().stream().map(user -> UserDTO.builder().id(user.getId()).name(user.getName()).phone(user.getPhone()).build()).toList();
    }

    //method to login, if is valid the password and the email return true

    public boolean login(String email, String password) {
        if(userDAO.findUserByEmail(email).isEmpty()) throw new NotFoundedException();
        UserEntity user = userDAO.findUserByEmail(email).get();
        return Objects.equals(user.getPassword(), password);
    }
}
