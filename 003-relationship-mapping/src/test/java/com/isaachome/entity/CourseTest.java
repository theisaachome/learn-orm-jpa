package com.isaachome.entity;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CourseTest {

	static EntityManagerFactory emf;
	
	
	@BeforeAll
    static	void beforeAll() {
		emf = Persistence.createEntityManagerFactory("003-relationship-mapping");
	}

	@AfterAll
	static void afterAll() {
		if(emf !=null && emf.isOpen()) {
			emf.close();
		}
	}

	@Test
	void test() {
	}

}
