package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.revature.model.Band;
import com.revature.model.Genre;
import com.revature.util.ConnectionUtil;

public class BandRepositoryJdbc implements BandRepository {

	private static Logger LOGGER = Logger.getLogger(BandRepository.class);
	
	public boolean insert(Band band) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int parameterIndex = 0;
			String sql = "INSERT INTO BAND VALUES (NULL, ?, ?, ?, TO_DATE(?, 'MM/DD/YYYY'), ?, NULL)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(++parameterIndex, band.getName());
			statement.setString(++parameterIndex, band.getWebsite());
			statement.setString(++parameterIndex, band.getActive());
			statement.setString(++parameterIndex, band.getStartDate());
			statement.setLong(++parameterIndex, band.getGenre().getId());
			
			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LOGGER.error("Could not insert band.", e);
		}
		
		return false;
	}

	public boolean insertProcedure(Band band) {
		// TODO Auto-generated method stub
		return false;
	}

	public Set<Band> findAll() {
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM BAND B, GENRE G WHERE B.G_ID = G.G_ID";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			//The Band Set
			Set<Band> bands = new HashSet<>();
			while(result.next()) {
				bands.add(new Band(
						result.getLong("B_ID"),
						result.getString("B_NAME"),
						result.getString("B_WEBSITE"),
						result.getString("B_ACTIVE"),
						result.getString("B_START_DATE"),
						result.getString("BAND_HASH"),
						new Genre(
								result.getLong("G_ID"),
								result.getString("G_NAME")
								)
						));
			}
			
			if(bands.size() == 0) {
				return null;
			}
			
			return bands;
		} catch (SQLException e) {
			LOGGER.error("Could not retrieve all bands.", e);
		}
		
		return null;
	}

	public Band findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Band> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		LOGGER.info(new BandRepositoryJdbc().findAll());
	}
}
