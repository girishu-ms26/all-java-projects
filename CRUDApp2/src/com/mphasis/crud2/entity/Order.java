package com.mphasis.crud2.entity;

import java.sql.Date;

public class Order {
	
	private int onum;
	private Date odate;
	private double amount;
	private int cnum;
	private int snum;
	public int getOnum() {
		return onum;
	}
	public Date getOdate() {
		return odate;
	}
	public void setOdate(Date date) {
		this.odate = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public void setOnum(int onum) {
		this.onum = onum;
	}
		
}