package com.isaachome.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.persistence.CollectionTable;


@Entity
@Table(name="company_tbl")
public class Company implements Serializable{

	private static final long serialVersionUID = 5240825626388780750L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ElementCollection
	@CollectionTable(name = "company_phones")
	private List<String> phones;
	
	
	@ElementCollection
	@MapKeyColumn(name = "name")
	@CollectionTable(name = "company_properties")
	private Map<String, String> properties;
	
	@ElementCollection
	@CollectionTable(name="company_address")
	private List<Address> addresses ;
	
	@ElementCollection
	@MapKeyColumn(name="city")
	@CollectionTable(name="company_address_by_city")
	private Map<String, Address> addressByCity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhones() {
		return phones;
	}
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}
	
}
