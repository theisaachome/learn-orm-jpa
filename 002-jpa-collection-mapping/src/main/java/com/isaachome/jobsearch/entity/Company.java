package com.isaachome.jobsearch.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;

@Entity
public class Company  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ElementCollection()
	@CollectionTable(name = "phones",
	joinColumns = @JoinColumn(name="company"))
	private List<String> phone = new ArrayList<String>();
	
	@ElementCollection
	@MapKeyColumn(name = "name")
	@CollectionTable(name="PROPERTIES",
	joinColumns = @JoinColumn(name="company"))
	private Map<String, String>  properties = new HashMap<String, String>();
	
	@ElementCollection
	@MapKeyColumn(name = "location")
	@CollectionTable(joinColumns = @JoinColumn(name="company"))
	private Map<String, Address> address = new HashMap<String, Address>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhone() {
		return phone;
	}
	public void setPhone(List<String> phone) {
		this.phone = phone;
	}
	public Map<String, String> getProperties() {
		return properties;
	}
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}
	public Map<String, Address> getAddress() {
		return address;
	}
	public void setAddress(Map<String, Address> address) {
		this.address = address;
	}

	
	

}
