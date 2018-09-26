package com.revature;

import org.apache.log4j.Logger;

import com.revature.strings.BuilderAndBuffer;
import com.revature.strings.StringSample;

public class Driver {
	
	//It doesn't work!
	//public static void Main(String[] args) {
	
	
	/*
	 * A class extension is .java (source code)
	 * 
	 * A .class file is bytecode, and it's what
	 * the JVM can run.
	 */
	
	private static final Logger LOGGER = Logger.getLogger(Driver.class);
	
	public static void main(String[] args) {
		LOGGER.info("Amount of arguments: " + args.length);
		
		for(String argument: args) {
			LOGGER.info(new BuilderAndBuffer().building(
					new StringSample().stringManipulation(argument)));
		}
		
		new BuilderAndBuffer().performance();
	}
}
