package com.isaachome.entity;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
class FetchModeTest {

	static EntityManagerFactory emf;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("manager");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		if(emf !=null && emf.isOpen())emf.close();
	}

	@ParameterizedTest
	@ValueSource(ints = 1)
	void test_single_lazy_mode_fetching(int id) {
		var em = emf.createEntityManager();
		var contact =em.find(Contact.class, id);
		// em.detach(contact); // will not throw 
		em.close();
		assertThrows(LazyInitializationException.class,contact.getMember()::getName);
	}

}
