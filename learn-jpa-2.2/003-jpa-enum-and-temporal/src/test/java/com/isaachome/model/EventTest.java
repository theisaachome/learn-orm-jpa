package com.isaachome.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventTest {


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
		
		Event e = new Event();
		var s = new Speaker();
		s.setName("Joshua Long");
		s.setAddress("USA");
		s.setEmail("joshualong@gmail.com");
		s.setTitle("Java Advocate");
		
		e.setEventName("Java Conference 2022");
		e.setLocalDate(LocalDate.of(2023, 1, 12));
		e.setEventTime(LocalDateTime.of(2023,Month.JANUARY,12,  13, 10, 30));
		e.setSpeaker(s);
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}

}
