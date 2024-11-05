package com.isaac.learn.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "professor_seq")
    @SequenceGenerator(name = "professor_seq",sequenceName = "professor_seq")
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE,mappedBy = "professor")
    private Set<Course> courses = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
