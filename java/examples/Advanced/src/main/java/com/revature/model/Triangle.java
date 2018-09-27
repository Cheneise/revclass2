package com.revature.model;

import org.apache.log4j.Logger;

import com.revature.definition.Color;
import com.revature.definition.Shape;

/**
 * This class only provides behavior for the Right Triangle. It is also immutable.
 */
public final class Triangle extends Shape {
	private final static Logger LOGGER = Logger.getLogger(Triangle.class);
	
	private final Integer oppositeLeg;
	private final Integer adyacentLeg;
	private final Integer hypotenuse;

	public Triangle(Color color, Integer oppositeLeg, Integer adyacentLeg, Integer hypotenuse) {
		super("RIGHT TRIANGLE", color);
		LOGGER.trace("Args Triangle");
		
		if(!isRight(oppositeLeg, adyacentLeg, hypotenuse)) {
			//We need to throw an Exception if it's not a Right triangle
		}
		
		this.oppositeLeg = oppositeLeg;
		this.adyacentLeg = adyacentLeg;
		this.hypotenuse = hypotenuse;
	}

	/*
	 * Only the getters since our class is immutable
	 */
	
	public Integer getOppositeLeg() {
		return oppositeLeg;
	}

	public Integer getAdyacentLeg() {
		return adyacentLeg;
	}

	public Integer getHypotenuse() {
		return hypotenuse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((adyacentLeg == null) ? 0 : adyacentLeg.hashCode());
		result = prime * result + ((hypotenuse == null) ? 0 : hypotenuse.hashCode());
		result = prime * result + ((oppositeLeg == null) ? 0 : oppositeLeg.hashCode());
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
		if (adyacentLeg == null) {
			if (other.adyacentLeg != null)
				return false;
		} else if (!adyacentLeg.equals(other.adyacentLeg))
			return false;
		if (hypotenuse == null) {
			if (other.hypotenuse != null)
				return false;
		} else if (!hypotenuse.equals(other.hypotenuse))
			return false;
		if (oppositeLeg == null) {
			if (other.oppositeLeg != null)
				return false;
		} else if (!oppositeLeg.equals(other.oppositeLeg))
			return false;
		return true;
	}

	@Override
	public Double perimeter() {
		//Includes pythagorean theorem
		return oppositeLeg + adyacentLeg + Math.sqrt(Math.pow(oppositeLeg, 2) + Math.pow(adyacentLeg, 2));
	}

	@Override
	public Double area() {
		return Double.sum(oppositeLeg, adyacentLeg) / 2.0;
	}

	@Override
	public void describe() {
		LOGGER.info("A right triangle (American English) or right-angled triangle (British English) is a triangle in which one angle is a right angle (that is, a 90-degree angle)");
	}
	
	/**
	 * Validates if triangle is a right one, using the pythagorean theorem a^2 + b^2 = c^2.
	 * 
	 * It can be used without creating a triangle instance.
	 */
	public static boolean isRight(Integer oppositeLeg, Integer adyacentLeg, Integer hypotenuse) {
		return Math.pow(oppositeLeg, 2) + Math.pow(adyacentLeg, 2) == Math.pow(hypotenuse, 2);
	}
	
	/**
	 * Validates if triangle is a right one, using the pythagorean theorem a^2 + b^2 = c^2.
	 * 
	 * However, it receives a Triangle object instead of the sides.
	 */
	public static boolean isRight(Triangle triangle) {
		return Math.pow(triangle.oppositeLeg, 2) + Math.pow(triangle.adyacentLeg, 2) == Math.pow(triangle.hypotenuse, 2);
	}
}
