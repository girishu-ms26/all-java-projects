package com.java210.coachdemo;

public class MyApp {

	public static void main(String[] args) {
		// Creating objects for Cricket Coach		
		//Coach theCoach = new CricketCoach();		
		// Using those objects to invoke that method
		//System.out.println(theCoach.getDailyWorkout());
		// Creating objects for Tennis Coach
		Coach theCoach = new TennisCoach();	
		System.out.println(theCoach.getDailyWorkout());		
	}
}