package com.isaachome.entity;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MemberTest {
	
	private static EntityManagerFactory emf;
	@BeforeAll
	static void init () {
		emf =Persistence.createEntityManagerFactory("001-getting-started-jpa");
	}
	@AfterAll
	static void close() {
		if( emf != null && emf.isOpen()) {
			emf.close();
		}
	}

	@Test
	void test_createMember() {
		// create member object
		var mem=new Member();
		mem.setName("Thidar");
		var contact = new Contact();
		contact.setAddress("Yangon, Myanmar");
		contact.setPhone("09250832041");
		contact.setEmail("isaachome@gmail.com");
		
		mem.setContact(contact);
		
		var em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(mem);
		em.getTransaction().commit();
		
	}

}
