package com.isaachome.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	@Basic(optional = false)
	private String name;
	private double price;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;
}
