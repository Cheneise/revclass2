package com.revature;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class FirstClass {

	private static final Logger LOGGER = Logger.getLogger(FirstClass.class);
	
	public static void main(String[] args) {
		
		//System Standard Output (stdout)
		System.out.println("Hello World!");
		
		//System Standard Error (stderr)
		System.err.println("Oops, something went off.");
		
		//System Standard In (stdin) -> Wrapped within scanner
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input something: ");
		String message = scanner.nextLine();
		System.out.println("Your input was: " + message);
		scanner.close();
		
		/*
		 * Logging
		 */
		LOGGER.info("Hello from Logger");
		
		LOGGER.error("Error from Logger");
	}
}
