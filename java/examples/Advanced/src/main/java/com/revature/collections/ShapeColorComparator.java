package com.revature.collections;

import java.util.Comparator;

import com.revature.definition.Shape;

public class ShapeColorComparator implements Comparator<Shape> {

	@Override
	public int compare(Shape shape1, Shape shape2) {
		return shape1.getColor().getName().compareTo(shape2.getColor().getName());
	}
	
}
