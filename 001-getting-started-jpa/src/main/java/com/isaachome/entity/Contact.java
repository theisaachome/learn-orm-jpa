package com.isaachome.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Contact implements Serializable {


	private static final long serialVersionUID = 1L;
	private String email;
	private String phone;
	private String address;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
