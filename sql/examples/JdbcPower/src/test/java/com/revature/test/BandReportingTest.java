package com.revature.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.service.BandService;
import com.revature.service.BandServiceImpl;

public class BandReportingTest {
	private BandService bandService;
	
	private String testBandName;
	private long testBandId;
	
	@Before
	public void setUp() {
		bandService = new BandServiceImpl();
		testBandName = "METALLICA";
		testBandId = 1;
	}
	
	@Test
	public void reportAllBands() {
		assertTrue(bandService.getAllBands().size() > 0);
	}
	
	@Test
	public void reportBandsByName() {
		assertTrue(bandService.getBand(testBandName).size() > 0);
	}
	
	@Test
	public void reportBandById() {
		assertTrue(bandService.getBand(testBandId) != null);
	}
	
	@After
	public void tearDown() {
		bandService = null;
		testBandName = null;
		testBandId = 0;
	}
}
