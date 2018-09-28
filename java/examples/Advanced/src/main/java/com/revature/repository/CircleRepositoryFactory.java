package com.revature.repository;

import static com.revature.repository.CircleRepository.BUFFER_NAME;
import static com.revature.repository.CircleRepository.SERIAL_NAME;

public class CircleRepositoryFactory {

	/*
	 * Make the factory a Singleton
	 */
	
	private static final CircleRepositoryFactory factory = new CircleRepositoryFactory();
	
	private CircleRepositoryFactory() {}
	
	public static CircleRepositoryFactory getFactory() {
		return factory;
	}
	
	/*
	 * Factory behavior comes here
	 * 
	 * -> Each case could be initializing data (getting it from somewhere, etc).
	 * -> This parameters could be coming from a file.
	 */
	public CircleRepository getRepository(String name) {
		switch(name) {
		case BUFFER_NAME:
			return new CircleRepositoryBuffer();
		case SERIAL_NAME: 
			return new CircleRepositorySerial();
		default:
			throw new IllegalArgumentException("Un-supported CircleRepository specified");
		}
	}
}
