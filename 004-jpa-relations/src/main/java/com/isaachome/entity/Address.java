package com.isaachome.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="address")
public class Address implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String phone;
	private String email;
	private String street;

}
