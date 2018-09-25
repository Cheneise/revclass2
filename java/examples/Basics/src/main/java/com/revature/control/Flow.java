package com.revature.control;

import org.apache.log4j.Logger;

public class Flow {
	private static final Logger LOGGER = Logger.getLogger(Flow.class);
	
	public void control(boolean bo, char c, int i) {
		//Expression needs to evaluate as a boolean.
		if(bo) {
			LOGGER.info("Boolean is true");
		} else if (!bo && (i == 5)) {
			LOGGER.info("Boolean is false, and int is equals to 5");
		} else {
			LOGGER.info("Boolean is false or int not equals to 5");
		}
		
		/*
		 * When do you use it over if/else if/else?
		 * -> Simple boolean comparison (==)
		 * 
		 * byte, short, char, int and String only (OCA)
		 * 
		 * -> switches cascade between cases until a break is found (OCA).
		 * 
		 * -> switch cases cannot be variable (you can switch over a variable).
		 */
		switch(c) {
		case '5':
			LOGGER.info("This is the 5 character");
		case 5:
			LOGGER.info("This is the 5 number");
		default:
			LOGGER.info("No case matches.");
		}
		
		/*
		 * Loops
		 */
		
		/*
		 * for(initialization__s; stop condition; void)
		 * 
		 * All sections are optional.
		 */
		
		//Remember: that j is **block scope**.
		for(int j = 0; j <= 7; j++) {
			LOGGER.info(j);
		}
		
		for( ; i > 0; LOGGER.info(i--));
		LOGGER.info(i); //0
		
		//Infinite for loops that actually do something or waiting for something
		//are called Daemons
//		for(;;) {
//			
//		}
		
		/*
		 * while(stop condition)
		 */
		
		//Same as classic for loop
		int j = 0;
		while(j <= 7) {
			LOGGER.info(j);
			j++;
		}
		//j here is 8
		
		while(j >= 0) {
			if(j % 2 == 0) {
				LOGGER.info(j);
			}
			j--;
		}
		
		//Let's achieve the same with a different approach
		j = 8;
		while(j >= 0) {
			if(j % 2 != 0) {
				j--;
				continue;
			}
			LOGGER.info(j--);
		}
		
		//Infinite approach
		j = 8;
		while(true) {
			if(j < 0) {
				break;
			}
			LOGGER.info(j--);
		}
		
		do {
			LOGGER.info("It will always execute the block logic at least once.");
		} while(false);
		
		if(j == -1) {
			return;
		}
		
		LOGGER.info("This won't ever print because of our logic.");
		return;
		
		//System.out.println(""); Unreachable
	}
	
	public String operators() {
		int first = 5;
		int second = 7;
		
		/*
		 * Arithmetic
		 */
		LOGGER.info(first + second); //12
		LOGGER.info(first - second); //-2
		LOGGER.info(first * second); //35
		
		//Be careful with integer division
		LOGGER.info(first / second); //0
		LOGGER.info(5 / 7);
		
		//Correct way
		LOGGER.info(5.0 / 7.0);
		double d = 5.0 / 7.0;
		
		//Truncates the floating part (no rounding)
		LOGGER.info((int) d);
		
		LOGGER.info(5.0/7);
		
		LOGGER.info(second % first); //2
		
		/*
		 * Incrementing/Decrementing
		 */
		int number = 4;
		
		//Post increment
		LOGGER.info(number++); //4
		
		//Pre increment
		LOGGER.info(++number); //6
		LOGGER.info(number--); //6
		LOGGER.info(number++); //5
		LOGGER.info(--number); //5
		
		/*
		 * Relational -> they evaluate to a boolean
		 */
		LOGGER.info(first > second);
		LOGGER.info(first >= second);
		LOGGER.info(first < second);
		LOGGER.info(first <= second);
		LOGGER.info(first == second);
		LOGGER.info(first != second);
		
		//Boolean
		
		//LOGGER.info(first && second); Only between boolean expressions!
		boolean firstCondition = true;
		boolean secondCondition = false;
		
		if(firstCondition || helper() || helper()) {
			LOGGER.info("Short circuit in action (for or)");
		}
		
		if(secondCondition && helper() && helper()) {}
		else {
			LOGGER.info("Short circuit in action (for and)");
		}
		
		if(firstCondition | helper() | helper()) {
			LOGGER.info("NON short circuit in action (for or)");
		}
		
		/*
		 * Ternary
		 * 
		 * (boolean expression) ? return if true:return if false
		 * 
		 * if(boolean expression) {
		 * 	return if true;
		 * } else {
		 *  return if false;
		 * }
		 */
		String message = (helper()) ? "This is a message":"Will never return this";
		LOGGER.info(message);
		
		return (helper()) ? "Good bye operators":"Never";
	}
	
	public boolean helper() {
		LOGGER.info("Calling the helper");
		return true;
	}
	
	public static void main(String[] args) {
		Flow flow = new Flow();
		flow.control(true, '5', 5);
		flow.control(new Boolean("FALSE"), (char) 874, new Integer("5"));
		
		
		/* Parameter scope in action */
		int myOutsideParameter = 5;
		flow.control(!true, (char) 5, myOutsideParameter);
		LOGGER.info("Parameter scope: " + myOutsideParameter); //5 -> You only sent a copy of the value
		
		LOGGER.info(flow.operators());
	}
}
