package com.revature.repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.definition.Color;
import com.revature.model.Circle;

/**
 * It must be ensured that the Circle class implements Serialazable, for that, make Shape Serialazable.
 *
 */
public class CircleRepositorySerial implements CircleRepository {

	private static final Logger LOGGER = Logger.getLogger(CircleRepositorySerial.class);

	/*
	 * Reads a single complete List of circles, even though you could store circle by circle
	 *  
	 * (non-Javadoc)
	 * @see com.revature.repository.CircleRepository#read()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Circle> read() throws Exception {
		/*
		 * Commented code represents reading a list of lists.
		 * 
		 * You have tom make sure that you catch EOFException (bad approach), know the count of objects (fine), or
		 * have a null at the end of the file (hard to achieve).
		 * 
		 * So it's just better to maintain one list to avoid complexity (solved in write method)
		 */

//		ObjectInputStream input = new ObjectInputStream(new FileInputStream(SERIAL_FILE_LOCATION));
//
//		List<Circle> circles = null;
//		List<Circle> currentCircles;
//		while((currentCircles = (List<Circle>) input.readObject()) != null) {
//			if(circles == null) {
//				circles = new ArrayList<>(currentCircles);
//			} else {
//				circles.addAll(currentCircles);
//			}
//		}
//
//		input.close();
//
//		return circles;

		ObjectInputStream input = new ObjectInputStream(new FileInputStream(SERIAL_FILE_LOCATION));
		List<Circle> circles = (List<Circle>) input.readObject();
		input.close();
		return circles;
	}

	/*
	 * Ignores append to make it simple.
	 * 
	 * It also adds existing objects in the file to the passed List.
	 * 
	 * (non-Javadoc)
	 * @see com.revature.repository.CircleRepository#write(java.util.List, boolean)
	 */
	@Override
	public void write(List<Circle> circles, boolean append) throws Exception {
		//Re-use the data without having appending issues
		List<Circle> previousList;
		try {
			previousList = read();
		} catch(Exception e) {
			//Doesn't matter, means the file has nothing (it's throwin EOF)
			previousList = new ArrayList<>();
		}
		
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(SERIAL_FILE_LOCATION));

		circles.addAll(previousList);
		output.writeObject(circles);

		output.close();
	}

	public static void main(String[] args) throws Throwable {
		new CircleRepositorySerial().write(new ArrayList<>(
				Arrays.asList(
						new Circle(Color.BLACK, 4.67),
						new Circle(Color.BLACK, 4.89),
						new Circle(Color.BLUE, 98934.43)
						)), false);
		LOGGER.info(new CircleRepositorySerial().read());
	}
}
