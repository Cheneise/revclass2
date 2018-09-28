package com.revature;

import org.apache.log4j.Logger;

import com.revature.collections.CollectionInitializer;

/*
 * Turn TRACE off before running!
 */
public class DriverCollection {
	
	public static void main(String[] args) {
//		CollectionInitializer.list();
//		CollectionInitializer.set();
		
		//This line calls our whole collection demo since map() uses set(), and set() uses list()
		CollectionInitializer.map();
	}
}
