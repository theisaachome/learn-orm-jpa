package com.isaachome.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="categories")
@NamedQuery(name="Category.getCount",query="SELECT COUNT(c) FROM Category c")
@NamedQuery(name="Category.getAll",query="SELECT c FROM Category c")
@NamedQuery(name="Category.updateNameById",query="update Category c SET c.name = :name WHERE c.id = :id")
@NamedQuery(name="Category.findByNameLike",query="SELECT c FROM Category c WHERE lower(c.name) LIKE ?1")
public class Category  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescirption() {
		return description;
	}
	public void setDescirption(String descirption) {
		this.description = descirption;
	}
	
}
