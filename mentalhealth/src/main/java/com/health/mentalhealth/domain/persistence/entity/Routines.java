package com.health.mentalhealth.domain.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor // Agregado constructor sin argumentos
public class Routines {

    // Class routine, relation much to one with user

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Day is a String how monday...
    private String day;

    private double hour;

    //name and info about routine
    private String name;
    private String info;
    private int duration;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    @JsonIgnore
    private UserEntity user;

    // add public setter to 'user' property
    @JsonProperty("user") // Anotación de Jackson para deserialización
    public void setUser(UserEntity user) {
        this.user = user;
    }
}