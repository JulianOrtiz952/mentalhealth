package com.health.mentalhealth.domain.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Calendar {

    //Class calendar, relation much to one with user

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int year;
    private int month;
    private int day;
    private String info;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    @JsonIgnore
    private UserEntity user;


    // Agregado setter público para la propiedad 'user'
    @JsonProperty("user") // Anotación de Jackson para deserialización
    public void setUser(UserEntity user) {
        this.user = user;
    }

}
