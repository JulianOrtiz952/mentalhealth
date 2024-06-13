package com.health.mentalhealth.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RoutineDTO {

    private Long id;

    //Day is a String how monday...
    private String day;

    //Hour double need be rounded
    private double hour;

    //name and info about routine
    private String name;
    private String info;
    private int duration;

}
