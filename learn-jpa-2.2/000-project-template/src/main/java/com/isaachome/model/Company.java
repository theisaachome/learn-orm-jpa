package com.isaachome.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;

import lombok.Data;
import javax.persistence.PrimaryKeyJoinColumn;

@Data
@Entity
@SecondaryTables({
@SecondaryTable(name = "address",
pkJoinColumns = @PrimaryKeyJoinColumn(name = "company", referencedColumnName = "id")),
@SecondaryTable(name="Info_details",
pkJoinColumns = @PrimaryKeyJoinColumn(name="company"))
})
public class Company implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String number;
	@Column(table = "address")
	private String street;
	@Column(table = "address")
	private String phone;

	@Column(table = "Info_details")
	private String details;
	
}
