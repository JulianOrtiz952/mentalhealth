package com.health.mentalhealth.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CalendarDTO {

    //Calendar data transfer object to frontend
    private int year;
    private int month;
    private int day;
    private String info;

}
