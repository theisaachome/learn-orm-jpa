package com.isaac.learn.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
public class ManyToOneTest {


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
    void manageManyToOneAssociation(){
        var em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        // get the primary key of a course and a professor
        Long courseId = createCourse();
        Long professorId = createProfessor();
        Course course = em.find(Course.class, courseId);
        Professor professor = em.find(Professor.class, 1L);
        // add the association
        course.setProfessor(professor);
        em.getTransaction().commit();
        em.close();
    }

    @Test
    void useManyToOneAssociation(){
        Long courseId = prepareTestData();
        var em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        var course = em.find(Course.class, courseId);

        System.out.println(course.getProfessor());
        em.getTransaction().commit();
    }
    private Long prepareTestData() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        // get the primary key of a course and a professor
        Long courseId = createCourse();
        Long profId = createProfessor();

        // load Course and Professor entities by primary key
        Course course = em.find(Course.class, courseId);
        Professor prof = em.find(Professor.class, profId);

        // add the association
        course.setProfessor(prof);

        em.getTransaction().commit();
        em.close();

        return course.getId();
    }

    private Long createCourse() {
        return createCourse("Software Development 1");
    }

    private Long createCourse(String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Course course = new Course();
        course.setName(name);
        course.setStartDate(LocalDate.of(2018, 8, 15));
        course.setEndDate(LocalDate.of(2019, 5, 31));
        em.persist(course);

        em.getTransaction().commit();
        em.close();

        return course.getId();
    }

    private Long createProfessor() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Professor prof = new Professor();
        prof.setFirstname("Jane");
        prof.setLastname("Doe");
        em.persist(prof);
        em.getTransaction().commit();
        return prof.getId();
    }
}
