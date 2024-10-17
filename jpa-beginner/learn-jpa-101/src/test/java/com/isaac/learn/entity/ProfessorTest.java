package com.isaac.learn.entity;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {
    Logger log = Logger.getLogger(ProfessorTest.class.getName());
    static EntityManagerFactory entityManagerFactory ;

    @BeforeAll
    static  void init(){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }
    @AfterAll
    static void close(){
        if(entityManagerFactory != null && entityManagerFactory.isOpen()){
            entityManagerFactory.close();
        }
    }

    @Test
    void insertProfessor(){
        Professor professor = new Professor();
        professor.setFirstname("John");
        professor.setLastname("Doe");
        log.info("Insert-Test");
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(professor);
        entityManager.getTransaction().commit();
    }
    @Test
    void findProfessor(){
        log.info("Find-Test");
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Professor professor = entityManager.find(Professor.class, 1L);

        entityManager.getTransaction().commit();
        assertNotNull(professor);

    }
    @Test
    void updateProfessor(){
        log.info("Find-Test");
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Professor professor = entityManager.find(Professor.class, 1L);
         professor.setFirstname("Mercy Ngai Dip Thang");
        entityManager.getTransaction().commit();
        assertNotNull(professor);

    }

    Professor createProfessor(){
       var professor = new Professor();
        professor.setFirstname("John");
        professor.setLastname("Doe");
        return professor;
    }
}