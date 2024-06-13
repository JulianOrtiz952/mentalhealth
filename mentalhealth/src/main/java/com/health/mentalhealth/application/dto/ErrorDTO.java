package com.health.mentalhealth.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {

    //Error data transfer object to handleError and exceptions
    private String code;
    private String message;

}
