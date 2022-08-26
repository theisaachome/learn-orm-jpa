package com.isaachome.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PriceTest {

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
	void insert_test() {
		em.getTransaction().begin();
		Price price = new Price();
		price.setAmount(100);
		price.setCurrency(Currency.EUR);
		em.persist(price);
		assertNotNull(price.getId());
		em.getTransaction().commit();
	}

}
