package com.health.mentalhealth.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {

    //User data transfer object to frontend
    private long id;
    private String name;
    private String email;
    private String phone;

}
