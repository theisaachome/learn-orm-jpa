package com.isaachome.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String zipecode;
	private String city;
	private String state;
	private String country;
	public String getZipecode() {
		return zipecode;
	}
	public void setZipecode(String zipecode) {
		this.zipecode = zipecode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
