package com.revature.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.definition.Color;
import com.revature.model.Circle;

public class CircleRepositoryBuffer implements CircleRepository {

	private static final Logger LOGGER = Logger.getLogger(CircleRepositoryBuffer.class);
	
	/*
	 * Reads from a text file with lines formated as:
	 * 
	 * colorName 
	 * 
	 * (non-Javadoc)
	 * @see com.revature.repository.CircleRepository#read()
	 */
	@Override
	public List<Circle> read() throws IOException {
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(BUFFER_FILE_LOCATION));
		
		List<Circle> circles = new ArrayList<>();
		
		/*
		 * Reading block, we need to check if the read line is not null as stop condition
		 */
		String line;		
		while((line = reader.readLine()) != null) {
			String[] circleFields = line.split(BLANK_SPACE);
			
			if(circleFields.length != CIRCLE_PARAMETER_AMOUNT) {
				throw new IllegalArgumentException("File contains more than two arguments in line: " + line);
			} else {
				String colorName = circleFields[0];
				
				//If parsing fails, NumberFormatException -> Runtime
				Double radius = new Double(circleFields[1]);
				
				switch(colorName.toUpperCase()) {
				case "BLACK":
					circles.add(new Circle(Color.BLACK, radius));
					break;
				case "WHITE":
					circles.add(new Circle(Color.WHITE, radius));
					break;
				case "RED":
					circles.add(new Circle(Color.RED, radius));
					break;
				case "GREEN":
					circles.add(new Circle(Color.GREEN, radius));
					break;
				case "BLUE":
					circles.add(new Circle(Color.BLUE, radius));
					break;
				default:
					throw new IllegalArgumentException("File contains an invalid color on line: " + line);
				}
			}
		}
		
		reader.close();
		
		return circles;
	}

	/*
	 * Overriden version doesn't duck the exception just for the purpose of showing you the
	 * Java 7 (1.7) try-with-resources
	 * 
	 * 
	 * (non-Javadoc)
	 * @see com.revature.repository.CircleRepository#write(java.util.List, boolean)
	 */
	@Override
	public void write(List<Circle> circles, boolean append) {
		
		/*
		 * try-with-resources declared object must implement AutoCloseable
		 * 
		 * It saves you the issue of having to close the resources yourself.
		 * 
		 * -> If multiple are declared, they will close in reverse order of declaration.
		 */
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(BUFFER_FILE_LOCATION, append))) {
			for(Circle circle: circles) {
				writer.write(circle.getColor().getName() + BLANK_SPACE + circle.getRadius());
			}
		} catch(IOException e) {
			LOGGER.error("Could not read circles from file", e);
		}
	}

	public static void main(String[] args) {
		try {
			LOGGER.info(CircleRepositoryFactory.getFactory().getRepository(CircleRepository.BUFFER_NAME).read());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//new CircleRepositoryBuffer().write(Arrays.asList(new Circle(Color.BLACK, 4.67)), true);
	}
}
