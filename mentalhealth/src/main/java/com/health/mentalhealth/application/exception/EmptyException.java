package com.health.mentalhealth.application.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmptyException extends RuntimeException {

    private String message;
    private String code;

    public EmptyException(){
        this.message="requirements are missing";
        this.code="400";
    }

    public EmptyException(String message){
        this.message=message + " is missing";
        this.code="400";
    }

}
