package com.isaachome.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sale")
public class Sale implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="sale_date")
	private LocalDate saleDate;
	@ManyToOne(optional = false)
	private Customer soldTo;
	
	@OneToMany(mappedBy = "sale",orphanRemoval = true)
	private List<ProductSale> products;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}
	public Customer getSoldTo() {
		return soldTo;
	}
	public void setSoldTo(Customer soldTo) {
		this.soldTo = soldTo;
	}
	public List<ProductSale> getProducts() {
		return products;
	}
	public void setProducts(List<ProductSale> products) {
		this.products = products;
	}
}
