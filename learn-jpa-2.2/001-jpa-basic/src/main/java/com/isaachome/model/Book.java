package com.isaachome.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	@Id
	private Long id;
	private String title;
	private Float price;
	private String description;
	private String isbn;
	private Integer nbOfPages;
	private Boolean illustrations;
}
