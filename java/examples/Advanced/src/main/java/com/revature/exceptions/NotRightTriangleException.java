package com.revature.exceptions;

/**
 * -> Unchecked exception (runtime)
 * -> Optional to catch/duck.
 * -> Usually represents bad coding practices (people not reading the documentation).
 * -> Can stop the flow of an application if not handled (it should)
 * -> Used by frameworks to reduce amount of exception handling code.
 */
public class NotRightTriangleException extends RuntimeException {

	/**
	 * Compatibility Java 1.x for Serialization
	 */
	private static final long serialVersionUID = 1L;

	public NotRightTriangleException(String message) {
		super(message);
	}
}
