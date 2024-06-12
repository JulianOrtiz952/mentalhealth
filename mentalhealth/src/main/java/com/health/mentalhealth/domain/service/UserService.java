package com.health.mentalhealth.domain.service;
import com.health.mentalhealth.application.exception.NotFoundedException;
import com.health.mentalhealth.application.exception.RequestException;
import com.health.mentalhealth.domain.persistence.dao.idao.IUserDAO;
import com.health.mentalhealth.domain.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserDAO userDAO;


    public UserEntity createUser(UserEntity user) {
        if(user.getEmail().isEmpty() ||  user.getPassword().isEmpty()) throw new RequestException("401", "email or password required");
        userDAO.save(user);
        return user;
    }


    public void deleteUser(Long id) {
        if(userDAO.findById(id).isEmpty()) throw new NotFoundedException();
        userDAO.deleteById(id);
    }


    public Optional<UserEntity> getUser(Long id) {
        if(userDAO.findById(id).isEmpty()) throw new NotFoundedException();
        return userDAO.findById(id);
    }


    public List<UserEntity> getAllUser() {
        return (List<UserEntity>) userDAO.findAll();
    }

    public void updateUser(UserEntity user){
        if(userDAO.findById(user.getId()).isEmpty()) throw new NotFoundedException();
        else userDAO.save(user);
    }
}
