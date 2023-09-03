package com.java210.coachdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringApp {

	public static void main(String[]args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach myCoach = context.getBean("theCoach",Coach.class);
		
		System.out.println(myCoach.getDailyWorkout());
		
		context.close();
	}
}
