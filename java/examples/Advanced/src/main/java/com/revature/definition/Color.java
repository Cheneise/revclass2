package com.revature.definition;

import org.apache.log4j.Logger;

public final class Color {
	private static final Logger LOGGER = Logger.getLogger(Color.class);

	/*
	 * Classes can only use these static colors
	 */
	public static final Color BLACK;
	public static final Color WHITE;
	public static final Color RED;
	public static final Color GREEN;
	public static final Color BLUE;
	
	/*
	 * This block could be getting the color data from an external resource
	 */
	static {
		BLACK = new Color("BLACK", (short) 0, (short) 0, (short) 0);
		WHITE = new Color("WHITE", (short) 255, (short) 255, (short) 255);
		RED = new Color("RED", (short) 255, (short) 0, (short) 0);
		GREEN = new Color("GREEN", (short) 0, (short) 255, (short) 0);
		BLUE = new Color("BLUE", (short) 0, (short) 0, (short) 255);
	}
	
	private final String name;
	private final Short red;
	private final Short green;
	private final Short blue;
	
	private Color(String name, Short red, Short green, Short blue) {
		LOGGER.trace("Parameters Color");
		this.name = name;
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public String getName() {
		return name;
	}

	public Short getRed() {
		return red;
	}

	public Short getGreen() {
		return green;
	}

	public Short getBlue() {
		return blue;
	}

	/**
	 * @Override annotation is optional. It ensures at compile time the that method
	 * is properly overridden.
	 */
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
