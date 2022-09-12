package com.isaachome.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class CustomerTest extends AbstractPersistenceTest{

	
	@Test
	void shouldCreateACustomer() {
		Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "1234565", LocalDate.now(), LocalDateTime.now());
		tx.begin();
		em.persist(customer);
		tx.commit();

		assertNotNull(customer.getId(),"ID should not be null");
	}

}
