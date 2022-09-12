package com.isaachome.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Customer {

	@Id
	  @GeneratedValue
	  private Long id;
	  private String firstName;
	  private String lastName;
	  private String email;
	  private String phoneNumber;
	  private LocalDate dateOfBirth;
	  private LocalDateTime creationDate;
	  
	  
	public Customer(String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth,
			LocalDateTime creationDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.creationDate = creationDate;
	}
	  
	  

}
