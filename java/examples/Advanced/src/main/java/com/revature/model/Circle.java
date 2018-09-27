package com.revature.model;

import org.apache.log4j.Logger;

import com.revature.definition.Color;
import com.revature.definition.Shape;

public class Circle extends Shape {
	private static final Logger LOGGER = Logger.getLogger(Circle.class);
	
	private Double radius;
	
	/*
	 * We don't have a default constructor anymore, so classes are forced to pass parameters.
	 */
	
	public Circle(Color color, Double radius) {
		super("CIRCLE", color);
		LOGGER.trace("Args circle");
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

	
	/*
	 * Override annotation is optional! It just helps to do a double check at compile time to check if a method it's properly
	 * overridden, because if you don't do it properly, it's a completely different method and virtual method invocation won't
	 * happen.
	 */
	@Override
	public Double perimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public Double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public final void describe() {
		LOGGER.info("A 2-dimensional shape made by drawing a curve that is always the same distance from a center.");
	}
}
