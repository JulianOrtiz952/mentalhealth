package com.health.mentalhealth.application.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class NotFoundedException extends RuntimeException {

    private String message;
    private String code;
    public NotFoundedException(){
        this.message="not founded :(";
        this.code="404";
    }

    public NotFoundedException(String message){
        this.message=message;
        this.code="404";
    }


}
