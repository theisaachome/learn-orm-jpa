package com.isaachome.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractQueryTest {

	protected EntityManagerFactory emf;
	protected EntityManager em;
	@BeforeEach
	void init() {
		emf = Persistence.createEntityManagerFactory("jpa-query");
		em = emf.createEntityManager();
	}
	@AfterEach
	void afterEach() {
		if(emf !=null && emf.isOpen()) {
			emf.close();
		}
	}
	
}
