package com.revature.repository;

import java.util.List;

import com.revature.model.Circle;

/**
 * Used with the purpose of interface driven development on
 * persistence of Circle objects.
 */
public interface CircleRepository {
	
	public static final String SERIAL_NAME = "SERIAL";
	public static final String SERIAL_FILE_LOCATION = "files/serial.txt";
	public static final String BUFFER_NAME = "BUFFER";
	public static final String BUFFER_FILE_LOCATION = "files/buffer.txt";

	public static final String BLANK_SPACE = " ";
	public static final int CIRCLE_PARAMETER_AMOUNT = 2;
	
	/**
	 * Reads a list of circles from a data store.
	 */
	List<Circle> read() throws Exception;
	
	/**
	 * Writes given circles list on a data store.
	 * 
	 * It appends if the passed boolean is true
	 */
	void write(List<Circle> circles, boolean append) throws Exception;
}
