package com.isaachome.model;

import javax.persistence.Embeddable;

import lombok.Data;


@Data
@Embeddable
public class Speaker {

	private String name;
	private String email;
	private String address;
	private String title;
}
