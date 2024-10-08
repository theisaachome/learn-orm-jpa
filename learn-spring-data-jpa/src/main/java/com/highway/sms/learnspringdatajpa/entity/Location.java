package com.highway.sms.learnspringdatajpa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String state;
	private String country;

	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="LOCATION_ID")
	private List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();

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

	public List<Manufacturer> getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(List<Manufacturer> manufacturers) {
		this.manufacturers = manufacturers;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Location{" +
				"id=" + id +
				", state='" + state + '\'' +
				", country='" + country + '\'' +
				'}';
	}
}
