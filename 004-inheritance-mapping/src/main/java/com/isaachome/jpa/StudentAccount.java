package com.isaachome.jpa;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class StudentAccount extends Account{

	@OneToOne
	private Address address;
}
