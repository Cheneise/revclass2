package com.revature.repository;

import java.util.Set;

import com.revature.model.Band;

/**
 * Data Access Object (DAO) -> Design Pattern
 * 
 * It's an object utilized with the *ONLY PURPOSE* of performing
 * data access operations (CRUD operations -> DML)
 * 
 * C -> Create (SQL Insert)
 * R -> Read (SQL Select)
 * U -> Update (SQL Update)
 * D -> Delete (SQL Delete)
 * 
 * -> It uses Interface-driven development (Abstraction)
 * -> You know the data access operations that are being performed, but not how
 * (JDBC, Serialization, MongoDB [NoSQL], Hibernate (Framework), etc.)
 */
public interface BandRepository {
	
	/**
	 * Insert operations
	 */
	
	/**
	 * Regular insert statement
	 * 
	 * @param band
	 * @return If the registration was successful
	 */
	boolean insert(Band band);
	
	/**
	 * It should use a CallableStatement and a stored procedure.
	 * 
	 * @param band
	 * @return If the registration was successful
	 */
	boolean insertProcedure(Band band);
	
	/**
	 * Read operations
	 */
	
	/**
	 * Fetches all existing bands.
	 * 
	 * @return
	 */
	Set<Band> findAll();
	
	/**
	 * Returns a band based on his ID (there is only one or none)
	 * 
	 * @param id
	 * @return
	 */
	Band findById(long id);
	
	/**
	 * Returns a group of bands depending on the name
	 * 
	 * @return
	 */
	Set<Band> findByName(String name);
	
	/**
	 * We won't add Update and Delete because is the same code as the insert.
	 */
}
