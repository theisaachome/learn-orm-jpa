package com.isaachome.model;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeTest {

	static EntityManagerFactory emf ;
	static EntityManager em;


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpa_ids");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}


	@BeforeEach
	 void setUp() throws Exception {
	  em = emf.createEntityManager();
	  em.getTransaction().begin();
	}
	@AfterEach
	 void tearDown() throws Exception {
	  em.getTransaction().commit();
	  em.close();
	}
	
	
	@Test
	void test() {
		
		var maung = new Employee();
		var peter = new Employee();
		maung.setName("Maung Maung");
		peter.setName("Peter");
		em.persist(maung);
		em.persist(peter);
		
		assertEquals(2, peter.getId());
	}

}
