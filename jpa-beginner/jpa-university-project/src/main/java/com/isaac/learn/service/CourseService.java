package com.isaac.learn.service;

import com.isaac.learn.model.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class CourseService {
    private EntityManager em;
    public CourseService(EntityManager em) {
        this.em = em;
    }

    public Course saveCourse(Course course) {
        em.persist(course);
        return course;
    }
    public Course findById(Long id) {
        return em.find(Course.class, id);
    }
    public void removeCourse(Course course) {
        em.remove(course);
    }
    public Course findByName(String name) {
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course  c WHERE c.name=:name ", Course.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
    public int countStudentInCourse(Long id){
        Query query = em.createQuery("SELECT SIZE(c.students) FROM Course c WHERE c.id=:id", Course.class);
        query.setParameter("id", id);
        return (int) query.getSingleResult();
    }
}
