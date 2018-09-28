package com.revature.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.revature.definition.Color;
import com.revature.definition.Shape;
import com.revature.model.Circle;
import com.revature.model.Triangle;

public class CollectionInitializer {
	private static final Logger LOGGER = Logger.getLogger(CollectionInitializer.class);
	
	public static List<Shape> list() {
		LOGGER.trace("----------LISTS------------");
		
		//Don't do this.
		List dont = new ArrayList();
		
		//You can't do this
		//List<int> cant;
		
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new Circle(Color.BLACK, 4.9));
		shapes.add(new Circle(Color.BLUE, 3.5));
		shapes.add(new Circle(Color.GREEN, 3.97));
		shapes.add(new Circle(Color.RED, 3.534));
		shapes.add(new Triangle(Color.BLUE, 3, 4 ,5));
		shapes.add(new Circle(Color.BLACK, 4.9));
		shapes.add(new Triangle(Color.BLUE, 432, 231, 24453));
		
		/*
		 * All Collections or Maps override toString().
		 */
		LOGGER.info(shapes);
		
		/*
		 * Iterating
		 */
		
		//Classic, Lists are indexed, we can
		for(int i = 0; i < shapes.size(); i++) {
			LOGGER.info(shapes);
		}
		
		//Enhanced
		for(Shape shape: shapes) {
			LOGGER.info(shape);
		}
		
		/*
		 * Old-school, before enhanced loop
		 * 
		 * This behavior is abstract now by the for each loop.
		 */
		Iterator<Shape> iterator = shapes.iterator();
		while(iterator.hasNext()) {
			LOGGER.info(iterator.next());
		}
		
		/*
		 * Useful methods/approaches
		 */
		List<Shape> oldList = new ArrayList<>(shapes);
		
		//First ocurrence only (so we need a loop to delete all same circles)
		while(shapes.remove(new Circle(Color.BLACK, 4.9)));
		
		LOGGER.info(shapes);
		
		//Concatenate two Collections (in this case, duplicating itself)
		shapes.addAll(shapes);
		
		/*
		 * Explore everything you can do with collections methods
		 * 
		 * Recommendation: Explore Java 8 features -> Streams, Predicates, Filters
		 */
		
		//Removing circles
		shapes.removeIf((Shape shape) -> shape.getName().equals("CIRCLE"));
		LOGGER.info(shapes);
		
		//Stream sample
		LOGGER.info("Before state of oldList " + oldList);
		
		oldList.stream()
		.filter((shape) -> shape.getName().equals("CIRCLE"))
		.forEach((shape) -> LOGGER.info(shape));
		
		LOGGER.info("After streaming, collection is not affected: " + oldList);
		
		return oldList;
	}
	
	public static Set<Shape> set() {
		LOGGER.trace("----------SET------------");
		
		Set<Shape> shapes = new HashSet<>(list());
		
		/*
		 * Two properties:
		 * 
		 * -> Order is different than in List.
		 * -> Repeated circle is not there.
		 */
		LOGGER.info(shapes);
		
		LOGGER.info(shapes.add(new Circle(Color.BLACK, 4.9)));
		
		/**
		 * Sorting
		 */
		Set<Shape> sorted = new TreeSet<>();
//		Set<Shape> sorted = new TreeSet<>();
//		sorted.add(new Circle(Color.BLUE, 3.5));
		LOGGER.info(sorted);
		
		/*
		 * We are not going to re-design Shape.
		 * 
		 * Use List to sort.
		 */
		List<Shape> sortedList = new ArrayList<>(shapes);
		Collections.sort(sortedList);
		LOGGER.info(sortedList);
		
		sorted = new TreeSet<>(new ShapeColorComparator());
		sorted.addAll(shapes);
		LOGGER.info(sorted);
		
		/*
		 * Again Java 8
		 */
		sorted = new TreeSet<>((shape1, shape2) -> shape1.getColor().getName().compareTo(shape2.getColor().getName()));
		sorted.addAll(shapes);
		LOGGER.info(sorted);
		
		return shapes;
	}
	
	public static Map<Integer, Shape> map() {
		LOGGER.trace("----------MAP------------");
		
		Map<Integer, Shape> map = new HashMap<>();
		
		int count = 0;
		for(Shape shape: set()) {
			map.put(++count, shape);
		}
		
		LOGGER.info(map);
		
		/*
		 * Iterate
		 */
		
		//By the key
		for(Integer key: map.keySet()) {
			LOGGER.info(key + "=" + map.get(key));
		}
		
		//By the values
		for(Shape shape: map.values()) {
			LOGGER.info(shape);
		}
		
		//By entry set (fastest)
		for(Map.Entry<Integer, Shape> entry: map.entrySet()) {
			LOGGER.info(entry.getKey() + "=" + entry.getValue());
		}
		
		return map;
	}
}
