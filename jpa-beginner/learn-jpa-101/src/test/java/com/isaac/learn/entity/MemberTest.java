package com.isaac.learn.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

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
    void testInsertMember(){
        var member = new Member();
//        member.setId(1);
        member.setName("Aung Aung");
        member.setEmail("aungaung@gmail.com");
        member.setPhone("029837894");

        var member2 = new Member();
//        member.setId(2);
        member.setName("Mercy Nga Dip Thang");
        member.setEmail("mercyngaidipthang@gmail.com");
        member.setPhone("029837894");
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(member);
        entityManager.getTransaction().commit();
//        entityManager.close();
        entityManager.getTransaction().begin();
        entityManager.persist(member2);
        entityManager.getTransaction().commit();

    }

}