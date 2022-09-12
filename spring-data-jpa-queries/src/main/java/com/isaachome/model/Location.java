package com.isaachome.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String state;
	private String country;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="LOCATION_ID")
	private List<Manufacturer> manufacturers = new ArrayList<>();
	
	


}
