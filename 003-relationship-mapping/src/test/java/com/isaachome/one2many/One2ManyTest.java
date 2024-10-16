package com.isaachome.one2many;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class One2ManyTest {

	static EntityManagerFactory emf;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("003-relationship-mapping");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		if(emf!=null&& emf.isOpen()) {
			emf.close();
		}
	}

	@Test
	void test() {
	}

}
