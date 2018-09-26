package com.revature.strings;

import org.apache.log4j.Logger;

public class BuilderAndBuffer {
	
	private static final Logger LOGGER = Logger.getLogger(BuilderAndBuffer.class);
	
	public StringBuilder building(String value) {
		StringBuilder builder = new StringBuilder(value);
		
		//Java Awesome features	
		return new StringBuilder(
				builder.append(" Awesome")
				.append(" features")
				.delete(0, 15)
				.toString()
				.substring(0,4)
				.toUpperCase())
				.reverse();
	}
	
	public void performance() {
		StringBuilder builder = new StringBuilder();		
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10_000_000; i++) {
			builder.append("word");
		}
		long end = System.currentTimeMillis();
		long total = end - start;
		
		LOGGER.info("String builder took: " + total + " (ms)");
		
		StringBuffer buffer = new StringBuffer();		
		start = System.currentTimeMillis();
		for(int i = 0; i < 10_000_000; i++) {
			buffer.append("word");
		}
		end = System.currentTimeMillis();
		total = end - start;
		
		LOGGER.info("String buffer took: " + total + " (ms)");
	}
}
