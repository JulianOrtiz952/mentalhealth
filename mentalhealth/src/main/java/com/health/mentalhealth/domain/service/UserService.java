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

    public UserDTO createUser(UserEntity user) {
        if(user.getEmail().isEmpty() ||  user.getPassword().isEmpty()) throw new RequestException("401", "email or password required");
        if(userDAO.findUserByEmail(user.getEmail()).isPresent()) throw new EmailAlreadyExistException("email is linked in another account");
        userDAO.save(user);
        UserDTO userDTO = UserDTO.builder().id(user.getId()).name(user.getName()).phone(user.getPhone()).email(user.getEmail()).build();
        return userDTO;
    }

    public void deleteUser(Long id) {
        if(userDAO.findById(id).isEmpty()) throw new NotFoundedException();
        userDAO.deleteById(id);
    }

    public UserDTO getUser(Long id) {
        if(userDAO.findById(id).isEmpty()) throw new NotFoundedException();
        Optional<UserEntity> userEntity = userDAO.findById(id);
        UserEntity user = userEntity.get();
        return UserDTO.builder().id(user.getId()).name(user.getName()).build();
    }

    public List<UserDTO> getAllUser() {
        List<UserDTO> userDTOList = userDAO.findAll().stream().map(user -> UserDTO.builder().id(user.getId()).name(user.getName()).email(user.getEmail()).phone(user.getPhone()).build()).toList();
        return userDTOList;
    }

    public void updateUser(UserEntity user){
        if(userDAO.findById(user.getId()).isEmpty()) throw new NotFoundedException();
        else userDAO.save(user);
    }


    public boolean login(String email, String password) {
        if(userDAO.findUserByEmail(email).isEmpty()) throw new NotFoundedException();
        UserEntity user = userDAO.findUserByEmail(email).get();
        return Objects.equals(user.getPassword(), password);
    }
}
