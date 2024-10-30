package com.isaac.learn.entity;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


class PurchaseOrderTest {
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
    void insertPurchaseOrder(){
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setCustomerName("John Doe");
        purchaseOrder.setPurchaseDate(LocalDate.of(2018,1,1));
        var em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(purchaseOrder);
        em.getTransaction().commit();
    }
    @Test
    void updatePurchaseOrder(){
        var em= entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        PurchaseOrder purchaseOrder = em.find(PurchaseOrder.class, 1L);
        purchaseOrder.setCustomerName("A Happy Customer");
        em.getTransaction().commit();
    }
    @Test
    void removePurchaseOrder(){
        var em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        PurchaseOrder purchaseOrder = em.find(PurchaseOrder.class, 1L);
        em.remove(purchaseOrder);
        em.getTransaction().commit();
    }

}