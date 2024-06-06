package com.health.mentalhealth.application.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestException extends RuntimeException {

    private String code;
    public RequestException(String code, String message){
        super(message);
        this.code=code;
    }

}
