package com.isaac.learn.service;

import com.isaac.learn.model.Curriculum;
import jakarta.persistence.EntityManager;

public class CurriculumService {

    private EntityManager em;
    public CurriculumService(EntityManager em) {
        this.em = em;
    }
    public Curriculum findById(Long id) {
        return em.find(Curriculum.class, id);
    }
    public Curriculum saveCurriculum(Curriculum curriculum) {
        em.persist(curriculum);
        return curriculum;
    }
    public  void removeCurriculum(Curriculum curriculum) {
        em.remove(curriculum);
    }
}
