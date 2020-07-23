package com.isaachome.jobsearch.entity;

import javax.persistence.Entity;

@Entity
public class Candidate  extends Member{

	private static final long serialVersionUID = 1L;
	private String education;
	
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}

}
