package com.revature.exceptions;

/**
 * -> Checked exception (compile time)
 * -> Mandatory to catch/duck.
 * -> Usually represents possible issues with external resources (calling a database, calling an external application, accessing a file).
 * -> It can't stop the flow of an application since it needs to be handled
 * (However, you can duck it in the main() method, which is horrible, and throws it to the JVM)
 */
public class InitializationException extends Exception {

	/**
	 * Compatibility Java 1.x for Serialization
	 */
	private static final long serialVersionUID = 1L;
	
	public InitializationException(String message) {
		super(message);
	}

}
