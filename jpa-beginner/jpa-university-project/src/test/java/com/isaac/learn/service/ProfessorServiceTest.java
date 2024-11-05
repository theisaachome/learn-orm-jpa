package com.isaac.learn.service;

import com.isaac.learn.model.Professor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorServiceTest {

    EntityManagerFactory emf;
    ProfessorService professorService;
    EntityManager em;
    @BeforeEach
    void init(){
        emf = Persistence.createEntityManagerFactory("default");
        professorService = new ProfessorService(em);
    }
    @AfterEach
    void afterAll(){
       if(emf != null) emf.close();
    }

    @Test
    void saveProfessor(){
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        Professor professor = new Professor();
        professor.setFirstName("John");
        professor.setLastName("Doe");
        em.persist(professor);

        assertNotNull(professor.getId());
        em.getTransaction().commit();
        em.close();
    }
}