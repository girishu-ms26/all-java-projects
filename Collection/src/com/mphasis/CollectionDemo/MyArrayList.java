package com.mphasis.CollectionDemo;

import java.util.ArrayList;

public class MyArrayList {

	public static void main(String[] args) {
		
		ArrayList arr = new ArrayList(10);
		
		System.out.println("The initial size of array list is "+arr.size());
		
		arr.add("A");		arr.add("R");		arr.add("R");		arr.add("A");		arr.add("Y");
		arr.add("L");		arr.add("I");		arr.add("S");		arr.add("T");
		
		System.out.println("The current size of array list is "+arr.size());
		
		System.out.println("The contents of array list are "+arr);
	}
}