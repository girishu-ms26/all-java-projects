package com.java.exceptionhandling;

public class MyEmp {
	private String empName;
	private double Sal;
	
	public MyEmp(String empName,double Sal) {
		this.empName=empName;
		this.Sal=Sal;
	}
	public double calSal() {
		double netSal=0;
		try {
			if(Sal<5000) {
				throw new InvalidSalaryException();
			}
			else {
				netSal=netSal+Sal+(Sal*0.3);
			}
		}
		catch(InvalidSalaryException ise) {
			System.out.println("Salary cannot be less than 5000");
		}
		return netSal;
	}
}