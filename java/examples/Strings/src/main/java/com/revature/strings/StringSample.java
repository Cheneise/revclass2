package com.revature.strings;

import org.apache.log4j.Logger;

public class StringSample {
	
	private static final Logger LOGGER =  Logger.getLogger(StringSample.class);
	
	public String stringManipulation(String value) {
		LOGGER.trace("User input was: " + value);
		
		//Removes spaces start and end only.
		String modified = value.trim();
		
		//length() METHOD, get the char at an index
		for(int i = 0; i < modified.length(); i++) {
			System.out.print(modified.charAt(i));
		}
		System.out.println();
		
		//index of a character
		LOGGER.info(modified.indexOf('W'));
		
		//substring range -> [start, end)
		LOGGER.info(modified.substring(15, 19));
		
		//method chaining
		LOGGER.info(value.trim().substring(15, 19).toUpperCase());
		
		return modified;
	}
}
