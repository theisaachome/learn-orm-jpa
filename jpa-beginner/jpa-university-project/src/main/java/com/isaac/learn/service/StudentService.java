package com.isaac.learn.service;

import com.isaac.learn.model.Student;
import jakarta.persistence.EntityManager;

public class StudentService {

    private EntityManager em;
    public StudentService(EntityManager em) {this.em = em;}
    public Student saveStudent(Student student) {
        em.persist(student);
        return student;
    }
    public Student findById(Long id){
        return em.find(Student.class, id);
    }
    public void removeStudent(Student student) {
        em.remove(student);
    }
}
