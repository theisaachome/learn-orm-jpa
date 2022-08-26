package com.isaachome.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompanyTest {


	static EntityManagerFactory emf;
	static EntityManager em;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf =Persistence.createEntityManagerFactory("jpa-tables");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
	@Test
	void test() {
		em.getTransaction().begin();
		 Company c1 = new Company();
       c1.setName("XYZ");
       c1.setPhone("09250832041");
       c1.setStreet("Street 1");
       c1.setNumber("A1");
       c1.setDetails("DETAILS");
       em.persist(c1);
       em.getTransaction().commit();

	}

}
