package com.isaachome.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.Data;

@Entity
@Data
@NamedQuery(
	name = "Model.findAllModelsByType",
	query = "SELECT m FROM Model m WHERE m.modelType.name = :name"
		)
public class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;	
	private BigDecimal price;
	private int frets;
	@Column(name="woodtype")
	private String woodType;
	@Column(name="yearfirstmade")
	private Date yearFirstMade;
	@ManyToOne
	private Manufacturer manufacturer;

	@ManyToOne
	@JoinColumn(name = "modeltype_id")
	private ModelType modelType;
	
}
