package com.revature.numbers;

import org.apache.log4j.Logger;

public class Numbers {
	
	/*
	 * Also static scope
	 */
	private static final Logger LOGGER = Logger.getLogger(Numbers.class);
	
	/**
	 * -> Stored in the stack.
	 * -> Only long, double, and float can have suffixes (OCA)
	 * -> Yes, you can have hex syntax 0x000f
	 * -> Yes, you can use underscore (_) to separate big numbers.
	 * -> Up-casting is implicit.
	 * -> Down-casting is explicit, and you might lose precision (value).
	 * 
	 * ---------------------------------------
	 * -> This method is on the instance scope
	 */
	public void primitives() {
		
		//1 Bit
		boolean bo = true;
		
		//8 Bit
		byte b = -128;
		
		//16 Bit
		short s = 32767;
		
		//16 Bit (unsigned)
		char c = 65534;
		//c = -7; No!
		c = '5';
		
		/*
		 * 32 Bit
		 * 
		 * All whole number literals are considered an int by the compiler.
		 */
		int i = Integer.MAX_VALUE;
		// i = _2_147_483_647; No!
		i = 2_147_483_647;
		
		/*
		 * 64 Bit
		 * 
		 * Use the suffix to actually make it a long directly.
		 */
		long l = 78L;
		//l = 2_147_483_648; //No!
		l = 2_147_483_648L;
		
		/*
		 * 32 Bit floating point
		 */
		float f = 5; //Yes it works with int
		
		//All floating points literals are considered doubles
		//f = 2.5; No!
		//Use the suffix.
		f = 2.5f;
		
		/*
		 * 64 bit (use double all the time)
		 */
		double d = 5.0;
		d = 5.0d; //Yes
		
		/*
		 * Up-casting (implicit)
		 */
		i = b;
		i = s;
		i =  (int) s; //redundant

		
		/*
		 * Down-casting (explicit)
		 * 
		 * -> It will overflow is the size of the number is bigger than the casted version.
		 */
		i = 32769;
		s = (short) i;
		LOGGER.info(s);
		
		/*
		 * Can I?
		 */
		//i = f; No!
		
		//Same level casting
		f = i;
	}
	
	/**
	 * -> Wrapper classes are immutable (they are final, and the value they hold is also final)
	 * 
	 */
	public void wrappers() {
		//The only ones that change the name
		Integer i = 5;
		Character c = '5';
		
		//Everything else
		Boolean bo = true;
		
		/*
		 * Auto-boxing
		 * 
		 * equivalent: i = new Integer(7)
		 */
		i = 7;
		
		/*
		 * Un-boxing
		 * 
		 * equivalent: int primitive = i.<primitive>Value()
		 */
		int primitive = i;
		primitive = new Integer(5);
		
		/*
		 * Useful features
		 */
		
		//Changing between primitives without casting (more object oriented)
		byte b = i.byteValue();
		short s = i.shortValue();
		
		//Constructors (OCA)
		bo = new Boolean("TrUe");
		LOGGER.info(bo);
		
		//Static methods or fields
		Integer.parseInt("534");
		LOGGER.info(Integer.MAX_VALUE);
		
		//Use operators between primitives and wrappers
		LOGGER.info(7 + new Integer(8));
		
		//OCA
		LOGGER.info(5 + 5 + "Hello"); //10Hello -> Left to right evaluation order
		
		/*
		 * 5 + 7 (evaluate on the left)
		 * + "Hello" (string encountered)
		 * + 5 -> ("5") -> everything else becomes a String
		 * + 7 -> ("7")
		 */
		LOGGER.info(5 + 7 + "Hello" + 5 + 7);
	}
	
	/*
	 * Static Scope
	 */
	public static void main(String[] args) {
		//Calling instance scope from the static scope won't work.
		//primitives();
		
		//Remember the bare-minimum of instantiation
		//new Numbers().primitives();
		
		//Here is where you see the value of a reference
		Numbers numbers = new Numbers();
		numbers.primitives();
		numbers.wrappers();
	}
}
