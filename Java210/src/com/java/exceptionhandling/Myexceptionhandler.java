package com.java.exceptionhandling;

public class Myexceptionhandler {
	public static void main(String[]args) {
		int num1=10;
		int num2=5;
		int num3=1;
		int result=0;
		
		int arr[] = {10,20,30};
		
		try {
			result = num1 / (num2-num3);
			System.out.println("The result is "+result);
			for(int i=0;i<=4;i--) {
				System.out.println("The value at arr "+i+" is "+arr[i]);
			}
		}
		catch(ArithmeticException ae) {
			System.out.println("OOPs we cannot divide anything by ZERO");
		}
		catch(ArrayIndexOutOfBoundsException aioe) {
			System.out.println("Error Array is out of Bounds");
		}
		catch(Exception e) {
			System.out.println("Something Went Wrong");
		}
		finally{
			System.out.println("We are safe now We have handled all exceptions");
		}
	}
}