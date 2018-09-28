package com.revature;

import org.apache.log4j.Logger;

import com.revature.definition.Color;
import com.revature.exceptions.NotRightTriangleException;
import com.revature.exceptions.NullColorError;
import com.revature.model.Circle;
import com.revature.model.Triangle;

/**
 * REMEMBER: Anything that can be thrown, can be caught (Throwable)
 * 
 * With time, you need to also try to remember as many common exceptions as possible:
 * 
 * FileNotFoundException -> Exception
 * SQLException -> Exception (JDBC)
 * 
 * IllegalArgumentException -> Runtime
 * ArrayIndexOutOfBoundsException -> Runtime
 * ClassCastException -> Runtime
 * 
 * OutOfMemoryError -> Error (Runtime)
 * VirtualMachineError -> Error (Runtime)
 * AssertionError -> Error (Runtime)
 * 
 * ALSO: RuntimeException extends Exception extends Throwable
 * 		 Error extends Throwable
 * 
 */
public class DriverException {

	private static final Logger LOGGER = Logger.getLogger(DriverException.class);
	
	/*
	 * Notice the static block handling the exception
	 */
	public static void main(String[] args) {
		//Runtime in action (uncomment the fine one with the wrong one to test)
		new Triangle(Color.BLACK, 3, 4, 5);
		
		//-> Stops execution
		//new Triangle(Color.BLACK, 4935, 342, 242);
		
		//Try catching the runtime now
		try {
			new Triangle(Color.BLACK, 4935, 342, 242);
		} catch (NotRightTriangleException e) {
			LOGGER.error("Attempted to create a non right triangle", e);
		}
		
		//Try the error now
		
		//-> Stops execution
		//new Circle(null, 5.4);
		
		//Remember that you can, but you shouldn't
		try {
			new Circle(null, 5.4);
		} catch (NullColorError e) {
			LOGGER.error("I will try to recover from the unrecoverable", e);
			//System.exit(0);
		} finally {
			LOGGER.info("And I will always execute! (Except for when System.exit(0) get's called)");
		}
	}
}
