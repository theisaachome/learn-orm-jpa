package com.isaac.learn.service;

import com.isaac.learn.model.Professor;
import jakarta.persistence.EntityManager;

public class ProfessorService {
    private EntityManager em;

    public ProfessorService(EntityManager em) {
        this.em = em;
    }
    public Professor saveProfessor(Professor p) {
        em.persist(p);
        return p;
    }

    public Professor findByIf(Long id){
        return em.find(Professor.class, id);
    }

    public void removeProfessor(Professor p) {
        em.remove(p);
    }
}
