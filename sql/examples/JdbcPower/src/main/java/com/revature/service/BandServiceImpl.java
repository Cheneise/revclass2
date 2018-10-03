package com.revature.service;

import java.util.Set;

import org.apache.log4j.Logger;

import com.revature.exception.BandRegistrationException;
import com.revature.model.Band;
import com.revature.repository.BandRepository;
import com.revature.repository.BandRepositoryJdbc;

public class BandServiceImpl implements BandService {

	private static Logger LOGGER = Logger.getLogger(BandService.class);
	
	//This is known as a Dependency
	/*
	 * Investigate dependency injection
	 */
	private BandRepository repository = new BandRepositoryJdbc();
	
	@Override
	public boolean registerBand(Band band) {
		//You could throw your own exception, validate band data before sending.
		boolean wasSuccessful = repository.insert(band);
		if(!wasSuccessful) {
			throw new BandRegistrationException("Invalid band data");
		}
		return wasSuccessful;
	}

	@Override
	public boolean registerBandSecure(Band band) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Band> getAllBands() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Band> getBand(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Band getBand(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
