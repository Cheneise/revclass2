package com.revature;

import com.revature.definition.Color;
import com.revature.definition.Shape;
import com.revature.model.Circle;

/**
 * Remember!
 * 
 * -> final vs finally vs finalize()
 * 
 * finalize()
 * -> Get's called by the garbage collector when an object is ready for being collected.
 * -> It was created with the purpose of providing additional clean-up
 * -> Doesn't do anything in the object class
 * 
 * -> GARBAGE COLLECTION CAN NEVER BE FORCE, ONLY SUGGESTED [System.gc()]
 */
public class DriverGC {
	
	public static void main(String[] args) {
		Shape s1 = new Circle(Color.RED, 8.9);
		Shape s2 = s1;
		//Only ready at end of the program, so we won't see it.
		Shape s3 = new Circle(Color.GREEN, 3.4);
		
		//Not ready, s2 points to s1 object
		s1 = null;
		
		for(int i = 0; i < 10; i++) {
			//Immediately ready
			new Circle(Color.BLUE, 7.9);
		}
		
		//Now it's ready the 8.9 one is ready
		s2 = null;
		
		System.gc();
		
		while(true) {
			//Immediately ready
			//System.gc();
		}
	}
}
