package com.health.mentalhealth.infrastructure.controller;

import com.health.mentalhealth.domain.persistence.entity.UserEntity;
import com.health.mentalhealth.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    //User Service
    @Autowired
    private UserService userService;

    //Get user by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    //Create user
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserEntity user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    //Delete user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("");
    }

    //Get all user
    @GetMapping
    public ResponseEntity<?> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

}
