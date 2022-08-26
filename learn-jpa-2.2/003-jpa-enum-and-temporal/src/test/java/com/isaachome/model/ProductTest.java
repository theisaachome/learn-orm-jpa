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


	static EntityManagerFactory emf;
	static EntityManager em;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf =Persistence.createEntityManagerFactory("jpa_enum");
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
		Product p = new Product();
		p.setName("Banana Cake");
		p.setExpires_date(LocalDate.of(2023, 1, 31));
		em.persist(p);
		em.getTransaction().begin();
		em.getTransaction().commit();
	}

}
