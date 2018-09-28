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
import java.util.Vector;

import org.apache.log4j.Logger;

import com.revature.definition.Calculable;
import com.revature.definition.Color;
import com.revature.definition.Shape;
import com.revature.model.Circle;
import com.revature.model.ConcurrentCircle;
import com.revature.model.Triangle;

public class CollectionInitializer {

	private static final Logger LOGGER = Logger.getLogger(CollectionInitializer.class);
	
	/*
	 * Remember:
	 * 
	 * -> Order of insertion is guaranteed.
	 * -> Repeated objects are accepted (if hashCodes are the same and equals is true, doesn't matter)
	 */
	public static List<Shape> list() {
		LOGGER.trace("---------------LISTS---------------");
		
		/*
		 * -> Don't do this ever, since you can mix Shapes with Lemonades with Objects with Strings
		 * -> This was Java before Generics
		 */
		List dont = new ArrayList();
		
		/*
		 * Remember!
		 * 
		 * You cannot use primitives, use the wrappers instead
		 */
		//List<int> list;
		
		/*
		 * -> Note that when we add generics, you will see the compile time safetiness in the methods,
		 * since for example, the .add method receives a Shape, because that was our declaration
		 * 
		 * -> Specifying the type in the right side is optional.
		 */
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new Triangle(Color.BLACK, 3, 4, 5));
		shapes.add(new Circle(Color.RED, 3.5));
		shapes.add(new Triangle(Color.GREEN, 45, 43, 42));
		shapes.add(new Circle(Color.BLUE, 4.14));
		shapes.add(new Circle(Color.WHITE, 9.0));
		//Repeated Circle
		shapes.add(new Circle(Color.WHITE, 9.0));
		
		/*
		 * -> We can print the whole list because ArrayList overrides toString()
		 * -> Note the repeated circle
		 */
		LOGGER.info(shapes);
		
		
		/**
		 * Iterating: Over a Collection -> Three ways
		 */
		
		/*
		 * Classic -> Lists are indexed, so we can get(index) -> this method comes from the List interface.
		 * 
		 * Remember: Array -> .length, String -> .length(), Collection -> .size()
		 */
		for(int index = 0; index < shapes.size(); index++) {
			LOGGER.info(shapes.get(index));
		}
		
		/*
		 * Enhanced -> Remember that Collection extends the Iterable interface, which allows us to use the enhanced for loop
		 */
		for(Shape shape: shapes) {
			LOGGER.info(shape);
		}
		
		/*
		 * Old school (before Java 5)
		 * 
		 * -> This is what the enhanced for loop abstracts from us in the case of Iterables.
		 * -> Remember that iterator() method is the only method in Iterable<T> (a few defaults added in Java 8, not important)
		 */
		Iterator<Shape> iterator = shapes.iterator();
		while(iterator.hasNext()) {
			LOGGER.info(iterator.next());
		}
		
		/**
		 * Some List/Collection methods (you don't really need to know where they come from, that's too advanced).
		 */
		LOGGER.info("isEmpty: " + shapes.isEmpty());
		
		/*
		 * This one will work because of equals overridden!
		 * 
		 * -> Returns if the object was removed successfully
		 * -> Only removes first ocurrence
		 */
		LOGGER.info("Removing 9.0 radius White circles: " + shapes.remove(new Circle(Color.WHITE, 9.0)));
		LOGGER.info(shapes);
		
		/*
		 * Yes, there is still one of the 9.0 circles (remove it and re-check)
		 */
		LOGGER.info("Still 9.0 circle available: " + shapes.contains(new Circle(Color.WHITE, 9.0)));
		shapes.remove(new Circle(Color.WHITE, 9.0));
		LOGGER.info("Still 9.0 circle available: " + shapes.contains(new Circle(Color.WHITE, 9.0)));
		
		//Add the list to itself, technically attach another collection to this list
		shapes.addAll(shapes);
		
		/*
		 * -> Copying the array
		 * -> You can use the constructors between different kind of collections as well
		 */
		List<Shape> oldVersion = new ArrayList<>(shapes);
		
		/*
		 * Java 8 wizardry
		 * 
		 * -> We are using the Predicate functional interface.
		 * -> Removing all Triangles!
		 */		
		shapes.removeIf((shape) -> shape.getName().equals("RIGHT TRIANGLE"));
		LOGGER.info("Filtered shapes: " + shapes);
		LOGGER.info("Old version: " + oldVersion);
		
		/**
		 * Recommend you to explore all methods!
		 */
		
		/*
		 * Also recommend you to explore the Stream API for Java 8, all collections have a stream() method now
		 * so you can chain operations in something similar to a collection.
		 * 
		 * -> Just as an introduction, here we are filtering like before and then printing one by one.
		 * (filter uses the Predicate<T> functional interface, and forEach uses the Consumer<T> one)
		 * (here the filter condition is backwards, because the other one removesIf, this one remainsIf)
		 * -> Behavior on the fly!
		 * 
		 * IT WILL HELP YOU A LOT IN BIG DATA
		 */
		oldVersion.stream()
		.filter((shape) -> shape.getName().equals("CIRCLE"))
		.forEach((shape) -> LOGGER.info(shape));
		
		return oldVersion;
	}
	
	public static Set<Shape> set() {
		LOGGER.trace("---------------SETS---------------");
		
		/**
		 * Regular sets (unsorted)
		 */
		
		//Reusing data from method created before
		Set<Shape> shapes = new HashSet<>(list());
		
		//HashSet.. and all concrete collections, override toString()
		LOGGER.info(shapes);
		
		/*
		 * You can only iterate over sets with for each or iterator, SETS ARE NOT INDEXED (they have a Map behind the scenes)
		 * 
		 * -> There is not get(index) method!
		 */
		//shapes.get() ??? -> The List interface has it
		for(Shape shape: shapes) {
			LOGGER.info(shape);
		}
		
		/*
		 * Try adding a duplicate and non duplicate object.
		 * 
		 * -> The duplicate object doesn't get added (propery of SETS)!
		 * false
		 * true
		 * 
		 * Now, for practice and re-iteration, comment equals and hashCode in the Circle class and re-run this.
		 * 
		 * -> Something that doesn't exist on the list doesn't get added either, it's comparing it partially
		 * because hashCode and equals on Shape don't check everything (only the color and the name, which is true)
		 * false
		 * false
		 * 
		 * Now comment also the hashCode and equals on Shape.
		 * 
		 * -> Both get added, since these objects are different per ==, behavior of equals in the Object class.
		 * true
		 * true
		 * 
		 * BROKEN BEHAVIOR! [Please uncomment all methods methods after testing]
		 */
		LOGGER.info("Repeated object added: " + shapes.add(new Circle(Color.RED, 3.5)));
		LOGGER.info("Repeated object added: " + shapes.add(new Circle(Color.RED, 43.7)));
		
		/*
		 * ----> You have the same methods as in List, you are mostly missing methods.
		 */
		
		/**
		 * Sorted Sets
		 */
		
		/*
		 * Reusing data from the HashSet
		 * 
		 * -> This will immediately break, since Shape doesn't implement Comparable, let's do that and retry
		 * (ClassCastException - trying to cast as a Comparable)
		 * 
		 * -> The JVM doesn't know how to sort the Shapes!
		 * 
		 * -> After fixing, is sorting by name (Circle, then Triangle)
		 * ----> But wait, there is a lot of deleted data
		 * ----> SortedSets consider two objects the same depending on what you are sorting with
		 * ----> In this case, the natural order is the name.. and the name repeats a lot!
		 */
		Set<Shape> sortedShapes = new TreeSet<Shape>(shapes);
		LOGGER.info(sortedShapes);
		
		 /* 
		 * Two options to fix this:
		 * ----> Always choose a natural order that uses a unique field [best solution] (e.g. ID, DATE, EMAIL, ETC)
		 * We can't use this one without re-designing in this project
		 * 
		 * ----> [Decent solution] that we can use in this project 
		 * (performance degradation, TreeSets are the fastest at sorting, also, if you add a new element, 
		 * it won't sort everything again):
		 * 
		 * Put the Data in an ArrayList, and sort that with the Collection**s utility class.
		 */
		List<Shape> sortedList = new ArrayList<>(shapes);
		Collections.sort(sortedList);
		LOGGER.info(sortedList);
		
		/*
		 * To sort in a different order than the natural, you can pass a Comparator to tell
		 * the TreeSet to sort in that specified order.
		 * 
		 * -> We have a ShapeColorComparator which compares by the color name.
		 * -> We still lose data, we only have shapes with different colors remaining.
		 * 
		 * To fix this issue, we will need the same solution as before.
		 */
		Set<Shape> anotherOrderSet = new TreeSet<>(new ShapeColorComparator());
		anotherOrderSet.addAll(shapes);		
		LOGGER.info(anotherOrderSet);
		
		//Check if nothing got deleted
		if(anotherOrderSet.size() == shapes.size()) {
			LOGGER.info("Nothing got deleted");
		} else {
			LOGGER.info("Something got deleted");
		}
		
		//Fixing, we are also passing the comparator this time around
		sortedList = new ArrayList<>(shapes);
		Collections.sort(sortedList, new ShapeColorComparator());
		LOGGER.info(sortedList);
		
		//Check if nothing got deleted (success)
		if(sortedList.size() == shapes.size()) {
			LOGGER.info("Nothing got deleted");
		} else {
			LOGGER.info("Something got deleted");
		}
		
		/*
		 * Learning from this:
		 * 
		 * ONLY USE TreeSet for sorting on UNIQUE fields, whether it is naturally or by Comparator.
		 */
		
		/*
		 * In Java 8, we could avoid creating separate Comparator classes.
		 * 
		 * Comparator is a classic example of a @Functional interface
		 * -> We can implement the compare(o1,o2) method on the fly!
		 * -> Let's do it descending (RED -> BLACK)
		 */
		sortedList = new ArrayList<>(shapes);
		Collections.sort(sortedList,
				(shape1, shape2) -> shape2.getColor().getName().compareTo(shape1.getColor().getName()));
		LOGGER.info(sortedList);
		
		//Check if nothing got deleted (success)
		if(sortedList.size() == shapes.size()) {
			LOGGER.info("Nothing got deleted");
		} else {
			LOGGER.info("Something got deleted");
		}
		
		/*
		 * Also remember that Ordered and Sorted are two completely different things
		 * 
		 * Ordered -> Order of insertion is guaranteed.
		 * Unordered -> Order of insertion is not guaranteed.
		 * Sorted -> The elements are being sorted by an algorithm (put in a different order)
		 * 
		 * List -> Ordered
		 * Set -> Unordered
		 * SortedSet -> Sorted
		 */
		
		//Proof
		HashSet<Integer> setIsUnordered = new HashSet<>();
		for(int i = 5000; i < 10000; i++) {
			setIsUnordered.add(i);
		}
		LOGGER.info("That is not the order I inserted: " + setIsUnordered);
		
		return shapes;
	}
	
	/*
	 * For Maps we have to keep it simple, since they are VERY extensive and it's a whole other API.
	 * 
	 * However, Maps are an excellent solution for a lot of computation problems and perform very well.
	 * 
	 * You just have to know:
	 * -> They are Key/Value pair structure
	 * -> They are not a Collection (NO IS-A RULE)
	 * -> They use collections which is different (They have a Key *Set*, and a Value *Collection*)
	 * -> How do you insert into a Map.
	 * -> How do you iterate on a Map.
	 * -> You can also sort Maps.
	 */
	public static Map<Integer, Shape> map() {
		LOGGER.trace("---------------MAPS---------------");
		
		Map<Integer, Shape> map = new HashMap<>();
		
		/*
		 * You insert with the put(key, value) method, there is no add here.
		 * 
		 * -> We are reusing the data on the set() method
		 */
		int count = 0;
		for(Shape shape: set()) {
			map.put(++count, shape);
		}
		
		/*
		 * All concrete maps override toString() as well.
		 */
		LOGGER.info(map);
		
		/**
		 * Iterate
		 * 
		 * Three ways:
		 * -> By the keys [.keySet()] -> Good options, since you can know both Key and Value.
		 * -> By the values [.values()] -> You cannot know the Key, but useful if you only mind of the Value.
		 * -> By the entry set [.entrySet() -> Set<Map.Entry<K,V>>] -> Most efficient, you technically get a ROW
		 */
		for(Integer key: map.keySet()) {
			LOGGER.info(key + "=" + map.get(key));
		}
		
		for(Shape shape: map.values()) {
			LOGGER.info(shape);
		}
		
		for(Map.Entry<Integer, Shape> row: map.entrySet()) {
			LOGGER.info(row.getKey() + "=" + row.getValue());
		}
		
		/*
		 * Maps are also *Unordered*, since they keys are a Set, which is *Unordered*
		 * 
		 * -> A TreeMap will sort by the key, with a SortedSet.
		 */
		Map<Integer, String> basic = new HashMap<>();
		basic.put(1, "Peter");
		basic.put(2, "Carlos");
		basic.put(4, "Alex");
		basic.put(7, "Maria");
		basic.put(34897, "Charles");
		
		//Also important, if the key already exists, put(k,v) replaces the value.
		basic.put(2, "Petronilo");
		
		LOGGER.info(basic);
		
		return map;
	}
	
	/**
	 * Utility method which returns a list with 10000 Circles in sequential
	 * order of radius as a List of Calculables.
	 * 
	 * Pass true to both parameters to receive a fully synchronized List
	 * 
	 * @param isConcurrentList The caller wants a concurrent version of the List
	 * @param isConcurrentObject The caller wants the data to be synchronized
	 */
	public static List<Calculable> initializeSequentialList(boolean isConcurrentList, boolean isConcurrentObject) {
		List<Calculable> sequential = null;
		if(!isConcurrentList) {
			sequential = new ArrayList<>();
		} else {
			sequential = new Vector<>();
		}
		
		for(double i = 0; i < 1_000_000; i++) {
			if(!isConcurrentObject) {
				sequential.add(new Circle(Color.BLACK, i));
			} else {
				sequential.add(new ConcurrentCircle(Color.BLACK, i));
			}
		}
		
		return sequential;
	}
}
