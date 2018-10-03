package com.revature.service;

import java.util.Set;

import com.revature.model.Band;

/**
 * SINGLE RESPONSIBILITY PRINCIPLE
 * 
 * 
 * The *ONLY PURPOSE* of a Service class should be
 * BUSINESS LOGIC (authentication, registration, validation)
 *
 */
public interface BandService {
	
	boolean registerBand(Band band);
	boolean registerBandSecure(Band band);
	Set<Band> getAllBands();
	Set<Band> getBand(String name);
	Band getBand(Long id);	
}
