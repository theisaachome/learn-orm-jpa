package com.isaachome.entity;

import javax.persistence.Entity;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.AttributeOverrides;

@Entity
public class Candidate extends Member {

	private static final long serialVersionUID = 1L;
	private String education;
	@AttributeOverrides({
		@AttributeOverride(name = "zipecode", column = @Column(name = "add_zipecode")),
		@AttributeOverride(name = "city", column = @Column(name = "add_city")),
		@AttributeOverride(name = "state", column = @Column(name = "add_state")),
		@AttributeOverride(name = "country", column = @Column(name = "add_country")) 
	})
	private Address address;
	@AttributeOverrides({
		@AttributeOverride(name = "zipecode", column = @Column(name = "con_zipecode")),
		@AttributeOverride(name = "city", column = @Column(name = "con_city")),
		@AttributeOverride(name = "state", column = @Column(name = "con_state")),
		@AttributeOverride(name = "country", column = @Column(name = "con_country")) 
	})
	private Address contact;
	
	
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Address getContact() {
		return contact;
	}
	public void setContact(Address contact) {
		this.contact = contact;
	}
	
	

}
