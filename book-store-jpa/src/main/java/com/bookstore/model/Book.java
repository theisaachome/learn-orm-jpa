package com.bookstore.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.NaturalId;

import lombok.Data;

@Entity
@Data
public class Book  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	@Version
	private int version;
	@Temporal(TemporalType.DATE)
	private Date publishingDate;
	
	@NaturalId
	private String isb;
	
	@ManyToOne
	@JoinColumn(name = "publisherid")
	private Publisher publisher;
	
	@ManyToMany
	@JoinTable(name = "BooKAuthor",
	joinColumns = {@JoinColumn(name="bookId",referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name="authorId",referencedColumnName = "id")})
	private Set<Author> authors = new HashSet<>();
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (title != null && !title.trim().isEmpty())
			result += "title: " + title;
		return result;
	}
}






