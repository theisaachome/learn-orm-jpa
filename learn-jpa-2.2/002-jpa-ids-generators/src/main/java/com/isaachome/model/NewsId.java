package com.isaachome.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class NewsId implements Serializable{

	private static final long serialVersionUID = 1L;
	private String title;
	private String language;
}
