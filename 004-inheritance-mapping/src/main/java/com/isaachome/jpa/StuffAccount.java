package com.isaachome.jpa;

import javax.persistence.Entity;

@Entity
public class StuffAccount extends Account {
 
	private  boolean isAdmin;

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
