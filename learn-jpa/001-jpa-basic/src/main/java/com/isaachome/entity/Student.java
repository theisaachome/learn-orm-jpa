package com.isaachome.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name = "student_tbl")
@SecondaryTables({ @SecondaryTable(name = "email_tbl"), @SecondaryTable(name = "phone_tbl") })
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String name;
	@Column(table = "email_tbl")
	private String email;
	@Column(table = "phone_tbl")
	private String phone;
	private String address;

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
