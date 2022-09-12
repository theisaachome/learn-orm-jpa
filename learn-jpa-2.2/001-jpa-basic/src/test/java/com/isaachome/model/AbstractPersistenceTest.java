package com.isaachome.model;

import java.sql.SQLException;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractPersistenceTest {

	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_basic");
	protected EntityManager em;
	protected EntityTransaction tx;

	@BeforeEach
	public void initEntityManager() throws Exception {
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	@AfterEach
	public void closeEntityManager() throws SQLException {
		if (em != null)em.close();
	}

	protected Long getRandomId() {
		return Math.abs(new Random().nextLong());
	}

}
