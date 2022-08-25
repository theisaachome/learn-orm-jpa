package com.isaachome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import javax.persistence.TableGenerator;

@Data
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "key_generator")
	@TableGenerator(name = "key_generator",
	pkColumnName = "key_name",
	pkColumnValue = "product_sequence",
	valueColumnName = "key_value"
	)
	private Integer id;
	private String name;
}
