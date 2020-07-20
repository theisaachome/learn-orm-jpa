package com.isaachome.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "student_tbl")
@SequenceGenerator(name = "student_seq")
public class Student implements Serializable {
	
	public enum Gender{
		Male,Female
	}

	   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_seq")
	private int id;
	private Date dateOfBirth;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Basic(optional = false)
	private String name;
	private String phone;
	@Column(length = 10)
	private String email;
	@Embedded
	private SecurityInfo securityInfo;
	
	@Transient
	private int discount;
	
	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}   
	
	
	
	public SecurityInfo getSecurityInfo() {
		return securityInfo;
	}



	public void setSecurityInfo(SecurityInfo securityInfo) {
		this.securityInfo = securityInfo;
	}



	public int getDiscount() {
		return discount;
	}



	public void setDiscount(int discount) {
		this.discount = discount;
	}



	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
   
}
