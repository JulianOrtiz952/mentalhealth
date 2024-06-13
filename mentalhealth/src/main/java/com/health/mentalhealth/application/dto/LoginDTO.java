package com.health.mentalhealth.application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDTO {

    //Login data transfer object to validation
    private String email;
    private String password;

}
