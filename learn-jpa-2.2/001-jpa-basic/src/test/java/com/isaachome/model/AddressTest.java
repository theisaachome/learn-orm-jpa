package com.isaachome.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class AddressTest extends AbstractPersistenceTest{

	

	@Test
	void shouldCreateAnAddress() {
		Address address = new Address(getRandomId(), "65B Ritherdon Rd", "At James place", "London", "LDN", "7QE554", "UK");
		tx.begin();
		em.persist(address);
		tx.commit();
		var persistedAddress = em.find(Address.class, address.getId());
		
		assertNotNull(persistedAddress.getId(),"Id should not be null");
	}

}
