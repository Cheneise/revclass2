package com.revature.definition;

import org.apache.log4j.Logger;

/**
 * This class only allows itself to create Colors. Classes from the outside
 * can only use the predefined colors this way.
 * 
 * It is also immutable.
 * 
 * This is another approach besides singleton, for a private constructor.
 */
public final class Color {
	private static final Logger LOGGER = Logger.getLogger(Color.class);
	
	public static final Color BLACK;
	public static final Color WHITE;
	public static final Color RED;
	public static final Color GREEN;
	public static final Color BLUE;
	
	/**
	 * This block could be calling the values from an external source, which makes it more maintainable
	 * in a block than up there initializing in-line.
	 */
	static {
		BLACK = new Color("BLACK", 0, 0, 0);
		WHITE = new Color("WHITE", 255, 255, 255);
		RED = new Color("RED", 255, 0, 0);
		GREEN = new Color("GREEN", 0, 255, 0);
		BLUE = new Color("BLUE", 0, 0, 255);
	}
	
	private final String name;
	private final Integer red;
	private final Integer green;
	private final Integer blue;
	
	private Color(String name, Integer red, Integer green, Integer blue) {
		LOGGER.trace("Parameters Color");
		this.name = name;
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public String getName() {
		return name;
	}

	public Integer getRed() {
		return red;
	}

	public Integer getGreen() {
		return green;
	}

	public Integer getBlue() {
		return blue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blue == null) ? 0 : blue.hashCode());
		result = prime * result + ((green == null) ? 0 : green.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((red == null) ? 0 : red.hashCode());
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
		Color other = (Color) obj;
		if (blue == null) {
			if (other.blue != null)
				return false;
		} else if (!blue.equals(other.blue))
			return false;
		if (green == null) {
			if (other.green != null)
				return false;
		} else if (!green.equals(other.green))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (red == null) {
			if (other.red != null)
				return false;
		} else if (!red.equals(other.red))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Color [name=" + name + ", red=" + red + ", green=" + green + ", blue=" + blue + "]";
	}
}
