package com.health.mentalhealth.application.exception;

import lombok.Data;

@Data
public class EmailAlreadyExistException extends RuntimeException {

    private String message;
    private String code;

    public EmailAlreadyExistException(){
        this.message="email already exist and ";
        this.code="409";
    }

    public EmailAlreadyExistException(String message){
        this.message=message;
        this.code="409";
    }

}
