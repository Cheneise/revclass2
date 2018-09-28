package com.revature.exceptions;

/**
 * -> You can catch or duck, but it makes no sense.
 * -> Represents a fatal issue (normally related to hardware)
 * -> We can also our custom ones to represent something that for our business,
 * there is no way that we can recover from.
 * (In this case we are saying that we cannot recover from a null colored figure).
 */
public class NullColorError extends Error {

	/**
	 * Compatibility Java 1.x for Serialization
	 */
	private static final long serialVersionUID = 1L;
	
	public NullColorError(String message) {
		super(message);
	}
}
