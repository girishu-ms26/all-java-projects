package com.java210.interfacedemo;

public interface I3 extends I1,I2 {
	void display();
}


/*
 * An interface can be derived from multiple interfaces
 * This is allowed in case of Interfaces because they are completely Abstract 
 * and We are not inheriting any behavior.
 * So it is completely safe to multiple inheritance in case of interfaces
 * 
 * This is unlike of Classes
 */
