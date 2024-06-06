package com.health.mentalhealth.domain.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class UserEntity {

    //User and principal class

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //basic attributes
    private String name;
    private String email;
    private String password;
    private String phone;

    //Calendar User relation
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Calendar> calendarList;

    //Alarm User relation
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Alarms> alarmsList;

    //Routine User relation
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Routines> routinesList;
}
