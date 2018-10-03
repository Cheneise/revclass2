package com.revature.exception;

public class BandRegistrationException extends RuntimeException {

	private static final long serialVersionUID = 5435635675078768408L;
	
	public BandRegistrationException(String message) {
		super(message);
	}
}
