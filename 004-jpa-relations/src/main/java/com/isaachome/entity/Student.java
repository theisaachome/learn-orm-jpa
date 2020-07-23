package com.isaachome.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="student")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	@OneToOne
	private Address address;
	
	@OneToMany
	private List<Course> courses;
	

}
