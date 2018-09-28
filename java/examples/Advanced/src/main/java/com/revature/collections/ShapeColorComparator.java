package com.revature.collections;

import java.util.Comparator;

import com.revature.definition.Shape;

/**
 * This comparator can be used to sort shapes by something different than their natural order (name),
 * in this case, by their color name.
 *
 */
public class ShapeColorComparator implements Comparator<Shape> {

	@Override
	public int compare(Shape shape1, Shape shape2) {
		return shape1.getColor().getName().compareTo(shape2.getColor().getName());
		
		/*
		 * For descending order, just flip the objects
		 */
		//return shape2.getColor().getName().compareTo(shape1.getColor().getName());
	}

}
