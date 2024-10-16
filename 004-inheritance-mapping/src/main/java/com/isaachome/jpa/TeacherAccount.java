package com.isaachome.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Entity
public class TeacherAccount extends  Account {

	private int exprienceYear;
	
	@OneToMany
	@JoinTable(name = "teaching_courses", joinColumns =
	@JoinColumn(name = "teacher_id",
	referencedColumnName = "id"))
	private List<Course> courses;

	public int getExprienceYear() {
		return exprienceYear;
	}

	public void setExprienceYear(int exprienceYear) {
		this.exprienceYear = exprienceYear;
	}
	
	
}
