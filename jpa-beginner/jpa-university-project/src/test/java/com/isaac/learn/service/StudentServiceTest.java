package com.isaac.learn.service;

import com.isaac.learn.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentServiceTest {

    EntityManagerFactory emf;
    StudentService studentService;
    EntityManager em;
    @BeforeEach
    void init(){
        emf = Persistence.createEntityManagerFactory("default");
        studentService = new StudentService(em);
    }
    @AfterEach
    void afterAll(){
        if(emf != null) emf.close();
    }

    @Test
    void saveStudent(){
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        var student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        em.persist(student);

//        assertNotNull(student.getId());
        em.getTransaction().commit();
        em.close();
    }

}