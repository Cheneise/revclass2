package com.revature.model;

import org.apache.log4j.Logger;

import com.revature.definition.Color;
import com.revature.definition.Shape;

public class Circle extends Shape {
	private static final Logger LOGGER = Logger.getLogger(Circle.class);
	
	private Double radius;

	public Circle(String name, Color color, Double radius) {
		super(name, color);
		//We can't log first line
		LOGGER.trace("Circle args");
		this.radius = radius;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((radius == null) ? 0 : radius.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		if (radius == null) {
			if (other.radius != null)
				return false;
		} else if (!radius.equals(other.radius))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", name=" + name + ", color=" + color + "]";
	}

	//"Clever math"
	public boolean isOdd(int n) {
		return Math.pow(-1, n) == -1;
	}
	
	@Override
	public Double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public Double perimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	protected void describe() {
		LOGGER.info("A round plane figure whose boundary (the circumference) "
				+ "consists of points equidistant from a fixed point "
				+ "(the center).");
	}
}
