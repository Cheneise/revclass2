package com.revature.model;

import org.apache.log4j.Logger;

import com.revature.definition.Color;
import com.revature.definition.Shape;

/**
 * A shape which includes calculation behavior for both Squares and Rectangles.
 */
public class Square extends Shape {
	private static final Logger LOGGER = Logger.getLogger(Square.class);
	
	private Double width;
	private Double length;
	
	public Square(Color color, Double width, Double length) {
		super("SQUARE", color);
		LOGGER.trace("Args square");
		this.width = width;
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((width == null) ? 0 : width.hashCode());
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
		Square other = (Square) obj;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (width == null) {
			if (other.width != null)
				return false;
		} else if (!width.equals(other.width))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Square [width=" + width + ", length=" + length + ", name=" + name + ", color=" + color + "]";
	}

	@Override
	public Double perimeter() {
		return 2 * Double.sum(width, length);
	}

	@Override
	public Double area() {
		return width * length;
	}

	@Override
	public final void describe() {
		LOGGER.info("A regular quadrilateral, which means that it has four equal sides and four equal angles (90-degree angles, or (100-gradian angles or right angles). It can also be defined as a rectangle in which two adjacent sides have equal length.");
	}
}
