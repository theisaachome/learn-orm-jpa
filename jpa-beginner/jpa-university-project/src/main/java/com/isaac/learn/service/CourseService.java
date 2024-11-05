package com.isaac.learn.service;

import com.isaac.learn.model.Course;
import jakarta.persistence.EntityManager;

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
}
