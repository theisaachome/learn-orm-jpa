package com.isaac.learn.model;

import jakarta.persistence.*;

@Entity
public class Curriculum {
    @Id
    private Long id;
    private String description;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Course course;

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
