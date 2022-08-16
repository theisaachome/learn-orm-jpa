package com.isaachome.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Lesson implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String name;
	@ManyToOne
	private Course course;
}
