package com.xebia.prizy.pricer.model;

import javax.persistence.*;

@Entity
public class SurveyProduct {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private Product product;
	
	@Column(nullable=false)
	private double priceByUser;
	
	private String notes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public double getPriceByUser() {
		return priceByUser;
	}

	public void setPriceByUser(double priceByUser) {
		this.priceByUser = priceByUser;
	}
	
}
