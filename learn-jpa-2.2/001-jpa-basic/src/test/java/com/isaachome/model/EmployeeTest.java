package com.isaachome.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;

class EmployeeTest extends AbstractPersistenceTest{

	

	@Test
	void test() {
		 Employee employee = new Employee("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());
		    tx.begin();
		    em.persist(employee);
		    tx.commit();
		    assertNotNull(employee.getId(),"Id should not be null.");
	}

}
