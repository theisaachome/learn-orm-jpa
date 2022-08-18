package com.bookstore.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;

@Data
@Entity
@Table(name = "book_tbl")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	@Version
	private int version;
	@OneToMany(mappedBy = "book")
	private List<Review> reviews  = new ArrayList<>();
	
	public void addReview(Review review) {
		this.reviews.add(review);
		review.setBook(this);
	}
}
