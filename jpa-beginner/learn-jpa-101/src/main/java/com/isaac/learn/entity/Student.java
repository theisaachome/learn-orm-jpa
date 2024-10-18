package com.isaac.learn.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    // when mapping Unidirectional it's good consider the amount of data
    // to be loaded
    // Example Load Course and  related Students will be huge data
    // So prefer to Student got owner of the relationship
    // Load student with registered course would be relatively less data.
    @ManyToMany(mappedBy = "students")
//    @JoinTable(
//            name = "enrollment",
//            joinColumns = @JoinColumn(name = "course_id"),
//            inverseJoinColumns = @JoinColumn(name = "student_id")
//    )
    private Set<Course> courses = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }


}
