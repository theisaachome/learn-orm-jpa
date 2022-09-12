package com.isaachome.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	public Employee(String firstName, String lastName, String email, String phoneNumber, Date dateOfBirth,
			Date creationDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.creationDate = creationDate;
	}

}
