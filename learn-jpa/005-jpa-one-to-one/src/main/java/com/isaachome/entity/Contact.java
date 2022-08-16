package com.isaachome.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Contact  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String phone;
	private String email;
	@OneToOne
	private Student  student;
}
