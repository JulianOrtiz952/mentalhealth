package com.health.mentalhealth.infrastructure.controller;

import com.health.mentalhealth.application.exception.NotFoundedException;
import com.health.mentalhealth.application.exception.RequestException;
import com.health.mentalhealth.application.dto.ErrorDTO;
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

    @ExceptionHandler(value = NotFoundedException.class)
    public ResponseEntity<ErrorDTO> notFoundedExceptionHandler(NotFoundedException er){
        ErrorDTO error = ErrorDTO.builder().code(er.getCode()).message(er.getMessage()).build();
        return ResponseEntity.badRequest().body(error);
    }

}
