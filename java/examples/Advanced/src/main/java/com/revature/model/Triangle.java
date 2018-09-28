package com.revature.model;

import org.apache.log4j.Logger;

import com.revature.definition.Color;
import com.revature.definition.Shape;

/**
 * This class can only handle Right Triangles.
 *
 */
public final class Triangle extends Shape {
	private static final Logger LOGGER = Logger.getLogger(Triangle.class);
	
	//One leg
	private final Integer a;
	
	//Second leg
	private final Integer b;
	
	//Hypotenuse
	private final Integer c;

	public Triangle(Color color, Integer a, Integer b, Integer c) {
		super("RIGHT TRIANGLE", color);
		
		if(!isRight(a, b, c)) {
			//I want to throw an exception here at some point.
		}
		
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Integer getA() {
		return a;
	}

	public Integer getB() {
		return b;
	}

	public Integer getC() {
		return c;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		result = prime * result + ((c == null) ? 0 : c.hashCode());
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
		Triangle other = (Triangle) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Triangle [a=" + a + ", b=" + b + ", c=" + c + ", name=" + name + ", color=" + color + "]";
	}

	@Override
	public Double area() {
		return (a * b) / 2.0;
	}

	@Override
	public Double perimeter() {
		//Using pythagorean theorem
		return a + b + Math.sqrt(Math.pow(a,2) + Math.pow(b, 2));
	}

	@Override
	public void describe() {
		LOGGER.info("A right triangle is triangle with an angle of 90 degrees (pi/2 radians). The sides a, b, and c of such a triangle satisfy the Pythagorean theorem");
	}
	
	/**
	 * Checks if a triangle is a right one, receiving its sides. (By the Pythagorean theorem).
	 */
	public static boolean isRight(Integer a, Integer b, Integer c) {
		return Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2);
	}
	
	/**
	 * Checks if a triangle is a right one, receiving a triangle object. (By the Pythagorean theorem).
	 */
	public static boolean isRight(Triangle triangle) {
		return Math.pow(triangle.a, 2) + Math.pow(triangle.b, 2) == Math.pow(triangle.c, 2);
	}
}
