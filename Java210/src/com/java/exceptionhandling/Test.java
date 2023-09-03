package com.java.exceptionhandling;

public class Test {
	public static void main(String[]args) {
		MyEmp E1 = new MyEmp("Rohit Sharma",500);
		double netSal = E1.calSal();
		if(netSal != 0) {
			System.out.println("The net salary is "+netSal);
		}
		else {
			System.out.println("net salary is "+netSal);
		}
	}
}