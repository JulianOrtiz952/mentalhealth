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
@NoArgsConstructor
public class Alarms {

    //class alarm, relation much to one with user

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int day;
    private double time;

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
