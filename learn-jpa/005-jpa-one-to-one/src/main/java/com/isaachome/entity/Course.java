package com.isaachome.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Course  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private String name;
	@OneToMany(mappedBy = "course")
	private List<Lesson> lessons;
}
