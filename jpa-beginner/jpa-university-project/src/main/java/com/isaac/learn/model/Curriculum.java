package com.isaac.learn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Curriculum {
    @Id
    private Long id;
    private String description;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
