package com.revature.definition;

public interface Calculable {
	/**
	 * Returns the perimeter of the Shape based on it's own particular state.
	 * 
	 * All Shapes calculate their perimeter differently, so the behavior must use
	 * the fields of the Concrete shape.
	 * 
	 * @return The perimeter in floating point format
	 */
	Double perimeter();
	
	/**
	 * Returns the area of the Shape based on it's own particular state.
	 * 
	 * All Shapes calculate their area differently, so the behavior must use
	 * the fields of the Concrete shape.
	 * 
	 * @return The area in floating point format
	 */
	Double area();
}
