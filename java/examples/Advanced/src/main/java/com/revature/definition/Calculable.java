package com.revature.definition;

public interface Calculable {
	//Remember, implicit public abstract
	
	
	/**
	 * Calculates the area of a Shape depending on
	 * it's internal parameters.
	 * 
	 * @return the area represented in floating point
	 */
	public abstract Double area();
	
	/**
	 * Calculates the perimeter of a Shape depending on
	 * it's internal parameters.
	 * 
	 * @return the perimeter represented in floating point
	 */
	Double perimeter();
}
