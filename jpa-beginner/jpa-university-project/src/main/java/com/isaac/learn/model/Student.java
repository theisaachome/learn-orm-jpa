package com.isaac.learn.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_seq")
    @SequenceGenerator(name = "student_seq",sequenceName = "student_seq")
    private Long id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.ORDINAL)
    private StudentStat state;

    @ManyToMany
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

    public StudentStat getState() {
        return state;
    }

    public void setState(StudentStat studentStat) {
        this.state = studentStat;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

}
