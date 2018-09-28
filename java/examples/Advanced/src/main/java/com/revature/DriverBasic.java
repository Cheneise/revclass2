package com.revature;

import org.apache.log4j.Logger;

import com.revature.definition.Color;
import com.revature.definition.Shape;
import com.revature.model.Circle;
import com.revature.model.Triangle;

public class DriverBasic {
	private static final Logger LOGGER = Logger.getLogger(DriverBasic.class);
	
	public static void main(String[] args) {
		/**
		 * Action!
		 */
		
		//Lazy loading for the Class
		LOGGER.info(Color.BLACK);
		
		//We can't call constructor
		Shape firstShape = new Circle(Color.BLACK, 4.0);
		
		if(firstShape instanceof Circle) {
			LOGGER.info("The instantiated shape is a Circle");
		}
		
		/*
		 * -> We cant see describe on Shape because it's protected. We need to cast.
		 * 
		 */
		Circle circle = (Circle) firstShape;
		if(circle == firstShape) {
			LOGGER.info("The circle, will always be a Circle.");
		}
		circle.describe();
		
		/*
		 * You can't see implementatation details of area (you don't mind).
		 */
		LOGGER.info("Area of the first circle: " + firstShape.area());
		LOGGER.info("Perimeter of the first circle: " + firstShape.perimeter());
		
		/*
		 * -> Circle is not immutable so we can change the parameter and
		 * recalculate.
		 */
		circle.setRadius(9.0);
		LOGGER.info("New Area of the first circle: " + firstShape.area());
		LOGGER.info("New Perimeter of the first circle: " + firstShape.perimeter());
		
		/*
		 *  == vs equals() [override]
		 */
		Shape secondShape = new Circle(Color.BLACK, 9.0);
		if(firstShape != secondShape) {
			LOGGER.info("Two different circles on the heap.");
		}
		if(firstShape.equals(secondShape)) {
			LOGGER.info("First and second circle have the same values.");
		}
		
		/*
		 * We are overriding toString
		 */
		LOGGER.info(firstShape);
		LOGGER.info(secondShape);
		
		/*
		 * Circle is not final, we can extend
		 */
		class CanExtend extends Circle {
			public CanExtend(Color color, Double radius) {
				super(color, radius);
			}
		}
		
		/**
		 * Triangle
		 */
		Shape thirdShape = new Triangle(Color.BLUE, 3, 4, 5);
		
		/*
		 * All pillars!
		 */
		Triangle triangle = (Triangle) thirdShape; //Polymorphism (covariance)
		
		triangle.describe(); //Encapsulation: was protected before and didn't work.
		
		//Abstraction
		LOGGER.info("Area of the first triangle: " + thirdShape.area());
		LOGGER.info("Perimeter of the first triangle: " + thirdShape.perimeter());
		
		// All of them in this case involve Inheritance.
		
		/*
		 * The different parts
		 */
		
		//Overloaded version
		if(Triangle.isRight(triangle)) {
			LOGGER.info("The first triangle is a right one.");
		} else {
			LOGGER.info("The first triangle is not a right.");
		}
		
		//Triangle is final!
//		class CantExtend extends Triangle {
//			
//		}
		
		/*
		 * This will break at some point (not a right triangle).
		 */
		Shape fourthShape = new Triangle(Color.RED, 43636, 342, 2424);
		
		LOGGER.info("Area: " + fourthShape.area());
		LOGGER.info("Perimeter: " + fourthShape.perimeter());
	}
}
