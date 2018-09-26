package com.revature.comparison;

import org.apache.log4j.Logger;

public class Compare {

	private static final Logger LOGGER = Logger.getLogger(Compare.class);
	
	public void equalsProof() {
		String s1 = "Java";
		String s2 = new String("Java");
		String s3 = "Java";
		
		LOGGER.info(s1 == s2); //false
		LOGGER.info(s1 == s3); //true
		LOGGER.info(s1.equals(s2)); //true (AND THIS IS WHAT YOU SHOULD DO!)
		
		Compare c1 = new Compare();
		Compare c2 = new Compare();
		Compare c3 = c2;
		
		LOGGER.info(c1 == c2); //false
		LOGGER.info(c1.equals(c2)); //false (I'm not overriding equals, therefore this is doing ==
		LOGGER.info(c2 == c3); //true
	}
	
	public static void main(String[] args) {
		new Compare().equalsProof();
	}

}
