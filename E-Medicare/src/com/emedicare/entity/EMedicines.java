package com.emedicare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMedicines")
public class EMedicines {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="medicineid")
	private int medicineid;
	
	@Column(name="medicine_name")
	private String medicine_name;
	
	@Column(name="manufacture_date")
	private String manufacture_date;
	
	@Column(name="type")
	private String type;
	
	@Column(name="price")
	private int price;
	
	@Column(name="description")
	private String description;
	
	@Column(name="seller")
	private String seller;
	
	@Column(name="quantityavailable")
	private int quantityavailable;
	
	

	public EMedicines() {
		super();
	}

	public EMedicines(int medicineid, String medicine_name, String manufacture_date, String type, int price,
			String description, String seller, int quantityavailable) {
		super();
		this.medicineid = medicineid;
		this.medicine_name = medicine_name;
		this.manufacture_date = manufacture_date;
		this.type = type;
		this.price = price;
		this.description = description;
		this.seller = seller;
		this.quantityavailable = quantityavailable;
	}

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

	public String getManufacture_date() {
		return manufacture_date;
	}

	public void setManufacture_date(String manufacture_date) {
		this.manufacture_date = manufacture_date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public int getQuantityavailable() {
		return quantityavailable;
	}

	public void setQuantityavailable(int quantityavailable) {
		this.quantityavailable = quantityavailable;
	}
	
	
	
	
}