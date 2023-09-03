package com.emedicare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

	
@Entity
@Table(name="Ecart")
public class ECart {
	
	@Id
	@Column(name="medicineid")
	private int medicineid;
	
	@Column(name="medicine_name")
	private String medicine_name;	
	
	@Column(name="price")
	private int price;
	
	@Column(name="description")
	private String description;


	public int getMedicineid() {
		return medicineid;
	}

	public void setMedicineid(int medicineid) {
		this.medicineid = medicineid;
	}

	public String getMedicine_name() {
		return medicine_name;
	}

	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
