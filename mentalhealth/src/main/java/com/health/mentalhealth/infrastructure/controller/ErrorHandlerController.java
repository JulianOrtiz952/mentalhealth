package com.health.mentalhealth.infrastructure.controller;

import com.health.mentalhealth.application.exception.RequestException;
import com.health.mentalhealth.domain.persistence.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ErrorDTO> requestExceptionHandler(RequestException er){
        ErrorDTO error = ErrorDTO.builder().code(er.getCode()).message(er.getMessage()).build();
        return ResponseEntity.badRequest().body(error);
    }

}
