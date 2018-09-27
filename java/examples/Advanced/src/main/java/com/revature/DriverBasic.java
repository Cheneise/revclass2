package com.revature;

import org.apache.log4j.Logger;

import com.revature.definition.Calculable;
import com.revature.definition.Color;
import com.revature.definition.Shape;
import com.revature.model.Circle;
import com.revature.model.Triangle;

public class DriverBasic {

	private static final Logger LOGGER = Logger.getLogger(DriverBasic.class);
	
	public static void main(String[] args) {
		/**
		 * ACTION!
		 */
		
		/* 
		 * It might be tricky to understand, but the classes are loaded if needed depending on the stack logic (lazy loading)
		 * 
		 * If we don't call that class it won't execute any of the static members.
		 * 
		 * To see the lazy loading effect, comment the line below.
		 */
		LOGGER.info(Color.BLACK);
		
		/*
		 * -> We cannot create a color because constructor is private, static color instead
		 * -> Note how Shapes constructor finishes before since we are doing the recursive super call
		 */
		Shape firstShape = new Circle(Color.BLACK, 3.0);
		
		/*
		 * -> Note that even though the reference is a Shape, the object is **instanceof** circle
		 */
		if(firstShape instanceof Circle) {
			LOGGER.info("The instantiated Shape IS A Circle");
		}
		
		/*
		 * -> We cannot see the describe method because of it's protected and we are outside of the package.
		 * -> However, the Circle class actually makes it public, so if we cast, we will see it.
		 * -> Also remember, that no matter if we cast, the object IS STILL A circle, and no copies were created
		 */
		Circle circle = (Circle) firstShape;
		if(circle == firstShape) {
			LOGGER.info("The circle is still the same object created before");
		}
		circle.describe();
		
		/*
		 * -> If you control click on the area() or perimeter() methods, here is where you see abstraction in action!
		 * -> You are not able to see the implementation details of the area method that the Circle has
		 * (because you technically don't know that it is a circle)
		 * -> However, virtual method invocation will call the Circle behavior!
		 */
		LOGGER.info("Area: " + firstShape.area());
		LOGGER.info("Perimeter: " + firstShape.perimeter());
		
		/*
		 * -> Circle is not immutable so we can change the radius on the same object, and re-execute
		 * (we need to use the Circle reference since that setter doesn't exist in shape).
		 */
		circle.setRadius(4.9);
		LOGGER.info("New radius set");
		LOGGER.info("New Area: " + firstShape.area());
		LOGGER.info("New Perimeter: " + firstShape.perimeter());
		
		/*
		 * Let's create a second circle
		 * 
		 * -> This is comparing everything, the name, the color, the radius, all of it. Becase we overrid .equals()
		 * -> However, the values of these two circles are not the same
		 */
		Shape secondShape = new Circle(Color.RED, 9.0);
		if(firstShape.equals(secondShape)) {
			LOGGER.info("First and second shape are two different circles");
		}
		
		/*
		 * Let's create a third circle
		 * 
		 * -> We all agree that == will always be false, since firstShape and thirdShape are pointing to different objects in the Heap.
		 * -> However, our equals method returns true because we overrid it!
		 * -> Remember we changed the radius up there.
		 */
		Shape thirdShape = new Circle(Color.BLACK, 4.9);
		if(firstShape != thirdShape) {
			LOGGER.info("This way == will never be true");
		}
		if(firstShape.equals(thirdShape)) {
			LOGGER.info("First and third shape have the same values!");
		}
		
		/*
		 * -> We can see the string version of our shape because we are overriding the toString() method in circle
		 * -> Or we could just check the radius on the circle reference
		 */
		LOGGER.info(firstShape);
		LOGGER.info(secondShape);
		LOGGER.info(thirdShape);
		
		//Can't only see this one, I would need to cast the other two
		LOGGER.info("Circle reference radius: " + circle.getRadius());
		
		/*
		 * -> Quick nested class to show that we can extend the Circle class
		 */
		@SuppressWarnings("unused")
		class CanExtend extends Circle {
			public CanExtend(Color color, Double radius) {
				super(color, radius);
			}
			
			/*
			 * We cannot override the describe() method because it's final! (Read compiler)
			 */
//			public void describe() {
//				
//			}
		}
		
		/*
		 * Let's play with the Triangle now which has a few more things
		 */

		Shape fourthShape = new Triangle(Color.BLUE, 3, 4, 5);
		
		/*
		 * -> ALL PILLARS AGAIN!
		 */
		Triangle triangle = (Triangle) fourthShape;
		triangle.describe();
		
		LOGGER.info("Area: " + fourthShape.area());
		LOGGER.info("Perimeter: " + fourthShape.perimeter());
		
		/*
		 * The different parts
		 */
		
		/*
		 * -> Triangle doesn't override toString(), nor Shape.
		 */
		LOGGER.info(triangle);
		
		/*
		 * Static method invocation! (Overloaded version that receives a triangle)
		 */
		if(Triangle.isRight(triangle)) {
			LOGGER.info("The passed triangle is Right");
		}
		
		/*
		 * -> The triangle class is immutable, you can't change the sides nor extend the class
		 * (Read the compiler!)
		 */
//		class CannotExtend extends Triangle {
//			
//		}
		
		/*
		 * This line will throw an exception at some point, because it's not a right triangle
		 * and our constructor validates it.
		 */
		Shape fifthShape = new Triangle(Color.BLUE, 4532, 24, 23424);
		
		LOGGER.info("Area: " + fifthShape.area());
		LOGGER.info("Perimeter: " + fifthShape.perimeter());
		
		/*
		 * -> And don't forget! Shape implements Calculable, so all of our shapes follow the IS A rule with that Interface!
		 * -> Control click here also takes us to the interface. In the past case, it happened as well, because Shape is abstract
		 * and it's not overriding the area() nor the perimeter() method.
		 */
		Calculable calculable = firstShape;
		LOGGER.info("First circle area: " + calculable.area());
		calculable = fourthShape;
		LOGGER.info("First triangle area: " + calculable.area());
	}
}
