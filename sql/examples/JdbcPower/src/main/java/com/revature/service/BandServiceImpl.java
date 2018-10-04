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
		LOGGER.trace("Calling band registration with: " + band);
		boolean wasSuccessful = repository.insert(band);
		if(!wasSuccessful) {
			throw new BandRegistrationException("Invalid band data");
		}
		return wasSuccessful;
	}

	@Override
	public boolean registerBandSecure(Band band) {
		LOGGER.trace("Calling band registration with (stored procedure): " + band);
		boolean wasSuccessful = repository.insert(band);
		if(!wasSuccessful) {
			throw new BandRegistrationException("Invalid band data for stored procedure.");
		}
		return wasSuccessful;
	}

	@Override
	public Set<Band> getAllBands() {
		LOGGER.trace("Fecthing all bands.");
		return repository.findAll();
	}

	@Override
	public Set<Band> getBand(String name) {
		LOGGER.trace("Fetching bands with name: " + name);
		return repository.findByName(name);
	}

	@Override
	public Band getBand(Long id) {
		LOGGER.trace("Fetching band with id: " + id);
		return repository.findById(id);
	}
	
}
