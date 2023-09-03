package com.assignment.baccounts;


public class Baccount {
	private String TransID;
	private int AccNo;
	private double OldBal;
	private String TransType;
	private double TransAmt;
	private double NewBal;
	private String TransStat;
	
	public Baccount() {
		
	}
	
	public Baccount(String transID, int accNo, double oldBal, String transType, double transAmt, double newBal,String transStat) {
		TransID = transID;
		AccNo = accNo;
		OldBal = oldBal;
		TransType = transType;
		TransAmt = transAmt;
		NewBal = newBal;
		TransStat = transStat;
	}
	public String getTransID() {
		return TransID;
	}
	public void setTransID(String transID) {
		TransID = transID;
	}
	public int getAccNo() {
		return AccNo;
	}
	public void setAccNo(int accNo) {
		AccNo = accNo;
	}
	public double getOldBal() {
		return OldBal;
	}
	public void setOldBal(double oldBal) {
		OldBal = oldBal;
	}
	public String getTransType() {
		return TransType;
	}
	public void setTransType(String transType) {
		TransType = transType;
	}
	public double getTransAmt() {
		return TransAmt;
	}
	public void setTransAmt(double transAmt) {
		TransAmt = transAmt;
	}
	public double getNewBal() {
		return NewBal;
	}
	public void setNewBal(double newBal) {
		NewBal = newBal;
	}
	public String getTransStat() {
		return TransStat;
	}
	public void setTransStat(String transStat) {
		TransStat = transStat;
	}

}
