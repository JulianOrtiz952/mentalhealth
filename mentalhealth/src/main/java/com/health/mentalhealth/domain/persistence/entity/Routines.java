package com.health.mentalhealth.domain.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Routines {

    //Class routine, relation much to one with user

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;

    @JsonIgnore
    @ManyToOne
    private UserEntity user;

}
