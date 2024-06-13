package com.health.mentalhealth.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AlarmDTO {

    //Alarm data transfer object to frontend
    private String name;
    private int day;
    private double time;
    private String message;

}
