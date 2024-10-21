package com.isaac.learn;

import jakarta.persistence.*;

import java.time.LocalDate;

@NamedQuery(
        name = Course.FIND_ALL_COURSES,
        query = "SELECT C FROM Course  C"
)
@Entity
public class Course {

    public static final String FIND_ALL_COURSES = "findAllCourses";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_generator")
    @SequenceGenerator(name="course_generator",sequenceName = "course_seq")
    private Long id;
    private String name;

    private LocalDate startDate;

    private LocalDate endDate;
    @Version
    private long version;

    @ManyToOne(fetch = FetchType.LAZY)
    private Professor professor;

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", version=" + version +
                ", professor=" + professor +
                '}';
    }
}
