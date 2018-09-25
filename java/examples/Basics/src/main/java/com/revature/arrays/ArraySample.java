package com.revature.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.apache.log4j.Logger;

public class ArraySample {
	
	private static final Logger LOGGER = Logger.getLogger(ArraySample.class);
	
	public void declareAndIterate() {
		int[] i;
		int j[];
		
		i = new int[5];
		//This requires left and right side.
		int[] k = {9, 8, 3023, 4};
		
		//This one doesn't need the whole declaration.
		j = new int[] {5, 7, 3};
		
		//Address in memory -> You will understand this soon.
		LOGGER.info(k);
		
		for(int index = 0; index < k.length; index++) {
			LOGGER.info(k[index]);
		}
		
		for(int value: k) {
			LOGGER.info(value);
		}
		
		//Remember!
		String message = "Hello";
		//Only for Array or Iterables!
//		for(char c: message) {
//			
//		}
		
		for(char c: message.toCharArray()) {
			System.out.print(c);
		}
		System.out.println();
		
		/*
		 * Multi-dimensional
		 * 
		 * -> Try not to use them but know how to.
		 */
		int[][] multi = new int[4][4];
		multi = new int[][] {{1,3,4,7},{4,6,7,4},{8,6,7,4},{-5,9,4,3}};
		
		for(int index = 0; index < multi.length; index++) {
			//multi[index] -> row
			for(int indexColumn = 0; indexColumn < multi[index].length; indexColumn++) {
				//You can't multi[i,j];
				System.out.print(multi[index][indexColumn] + " ");
			}
			System.out.println();
		}
		
		//Or
		for(int[] row: multi) {
			for(int value: row) {
				System.out.print(value);
			}
			System.out.println();
		}
		
		//Arrays (ascending)
		Arrays.sort(k);
		for(int value: k) {
			LOGGER.info(value);
		}
		
		//Descending
		Integer[] integerArray = new Integer[] {1, -875, -9, 90834};
		//You will learn comparator and lambdas soon.
		Arrays.sort(integerArray, (v1, v2) -> v2.compareTo(v1));
	}
	
	public static void main(String[] args) {
		new ArraySample().declareAndIterate();
	}
}
