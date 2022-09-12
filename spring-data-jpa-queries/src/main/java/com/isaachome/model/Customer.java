package com.isaachome.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CUSTOMERS")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerID;
	@JoinColumn(name="CUSTOMER_NAME")
	private String customerName;
	@JoinColumn(name="CONTACT_NAME")
	private String contactName;
	@JoinColumn(name="ADDRESS")
	private String address;
	@JoinColumn(name="ADDRESS")
	private String city;
	@JoinColumn(name="POSTALCODE")
	private String postalCode;
	@JoinColumn(name="COUNTRY")
	private String country;
}
