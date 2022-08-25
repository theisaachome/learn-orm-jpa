package com.isaachome.model;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {
	
	static EntityManagerFactory emf ;
	static EntityManager em;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpa-basic");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}
	
	@BeforeEach
	 void setUpBeforeEach() throws Exception {
	  em = emf.createEntityManager();
	  em.getTransaction().begin();
	}
	@AfterEach
	 void tearDownAfterEach() throws Exception {
	  em.getTransaction().commit();
	  em.close();
	}
	
	
	

	@Test
	void insert_new_product() {
		Product p1= new Product();
		p1.setId(1);
		p1.setExpirationDate(LocalDate.now());
		p1.setName("Tiger Beer");
		em.persist(p1);
	}

}
