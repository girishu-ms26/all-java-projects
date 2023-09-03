package com.java.exceptionhandling;

public class TestDate {
	public static void main(String[]args) {
		Date1 D1 = new Date1(3,2,2020);
		Date1 D2 = new Date1(31,2,2020);
		
		//System.out.println(D1+"\n"+D1.validateDate());
		System.out.println();
		//System.out.println(D2+"\n"+D2.validateDate());
		D1.validateDate();
		D2.validateDate();		
	}
}