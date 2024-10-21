package com.isaac.learn;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

@Log4j
class TestExampleProject {

    static EntityManagerFactory emf ;

    @BeforeAll
    static  void init(){
        emf = Persistence.createEntityManagerFactory("default");
    }
    @AfterAll
    static void close(){
        if(emf != null && emf.isOpen()){
            emf.close();
        }
    }

    @Test
    void jpqlFindAllCourses(){
        log.info("... adhocJpqlFindAllCourses ...");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // create an adhoc query to select all courses
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c", Course.class);
        List<Course> courses = query.getResultList();
        Assertions.assertNotNull(courses);
        Assertions.assertEquals(10, courses.size());
        for(Course course : courses){
            log.info(course);
        }
        em.getTransaction().commit();
    }

    @Test
    void namedJQOLFindAllCourses(){
        log.info("... adhocNamedJQOLFindAllCourses ...");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Course> query = em.createNamedQuery(Course.FIND_ALL_COURSES, Course.class);
        List<Course> courses = query.getResultList();
        Assertions.assertNotNull(courses);
        Assertions.assertEquals(10, courses.size());
        em.getTransaction().commit();
    }

    @Test
    void jpqlFindCourseByName(){
        log.info("... adhocJpqlFindCourseByName ...");
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c WHERE c.name = :name", Course.class);
        query.setParameter("name", "JPQL");
    }

}