package com.isaac.learn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Professor {
    @Id
    private Long id;
    private String firstname;
    private String lastname;
}
