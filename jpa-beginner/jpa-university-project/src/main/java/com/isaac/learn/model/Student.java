package com.isaac.learn.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQuery(name = Student.QUERY_STUDENT_BY_FIRSTNAME_AND_LASTNAME,
        query = "SELECT s FROM Student s WHERE s.firstName =:"+ Student.PARAM_FIRSTNAME + " and s.lastName=:"+Student.PARAM_LASTNAME)
public class Student {

    public static final  String QUERY_STUDENT_BY_FIRSTNAME_AND_LASTNAME = "query.studentByFirstnameAndLastname";
    public static final String PARAM_FIRSTNAME = "firstName";
    public static final String PARAM_LASTNAME = "lastName";
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
