package com.revature.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.exception.BandRegistrationException;
import com.revature.model.Band;
import com.revature.model.Genre;
import com.revature.service.BandService;
import com.revature.service.BandServiceImpl;

/**
 * This is our test case for Band Registration feature
 */
public class BandRegistrationTest {
	
	private BandService bandService;
	
	//Mock object (for good case)
	private Band testBand;
	
	//Mock object (for bad case)
	private Band testBandWrong;
	
	@Before
	public void setUp() {
		bandService = new BandServiceImpl();
		testBand = new Band(
				0, 
				"Mock Rock Band",
				"mock.com",
				"YES",
				"04/15/1998",
				null,
				new Genre(1, null));
		
		//trying to insert null name
		testBandWrong = new Band(
				0, 
				null,
				"mock.com",
				"YES",
				"04/15/1998",
				null,
				new Genre(1, null));
	}
	
	@Test
	public void registrationSuccess() {
		assertTrue(bandService.registerBand(testBand));
	}
	
	@Test
	public void registrationSuccessProcedure() {
		assertTrue(bandService.registerBandSecure(testBand));
	}
	
	@Test(expected = BandRegistrationException.class)
	public void registrationFailure() {
		bandService.registerBand(testBandWrong);
	}
	
	@Test(expected = BandRegistrationException.class)
	public void registrationFailureSecure() {
		bandService.registerBandSecure(testBandWrong);
	}
	
	@After
	public void tearDown() {
		bandService = null;
		testBand = null;
	}
}
