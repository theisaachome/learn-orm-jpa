package com.isaachome.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Track {

	 @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Long id;
	  private String title;
	  private Float duration;
	  @Basic(fetch = FetchType.LAZY)
	  @Lob
	  private byte[] wav;
	  private String description;
	public Track(String title, Float duration, String description) {
		super();
		this.title = title;
		this.duration = duration;
		this.description = description;
	}
	  
	  

}
