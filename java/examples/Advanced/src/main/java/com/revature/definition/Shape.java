package com.revature.definition;

import org.apache.log4j.Logger;

public abstract class Shape implements Calculable {
	private static final Logger LOGGER = Logger.getLogger(Shape.class);
	
	protected final String name;
	protected final Color color;
	
	public Shape(String name, Color color) {
		//super(); -----> Implicit!
		LOGGER.trace("Args shape");
		this.name = name;
		this.color = color;
	}
	
	/**
	 * Prints a brief explanation of the Shape
	 */
	protected abstract void describe();

	/*
	 * Fields of this class are immutable, no setters.
	 */
	
	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape other = (Shape) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
