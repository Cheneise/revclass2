package com.revature.model;

import java.io.Serializable;

/*
 * This is an Entity, because it's mapped to a database table.
 * 
 * Now, we made it a Java Bean, because:
 * -> Properly Encapsulated (private variables, public getters/setters).
 * -> Implements Serializable and Comparable
 * -> It overrides: hashCode, equals, and toString.
 * 
 * A Bean can also be considered a POJO (Plain Old Java Object).
 * 
 * In fact, any object that can be instantiated, is a POJO.
 */
public class Band implements Comparable<Band>, Serializable {
	
	/**
	 * Java 1.x Compatibility
	 */
	private static final long serialVersionUID = 3887065474193619807L;

	/**
	 * B_ID
	 */
	private long id;
	
	/**
	 * B_NAME
	 */
	private String name;
	
	/**
	 * B_WEBSITE
	 */
	private String website;
	
	// This could be a boolean and called isActive
	/**
	 * B_ACTIVE
	 */
	private String active;
	
	//In your project, it should be a Date (LocalDateTime)
	/**
	 * B_START_DATE
	 */
	private String startDate;
	
	/**
	 * BAND_HASH
	 */
	private String bandHash;
	
	/*
	* No! It should be a Genre
	* private long genreId;
	* 
	* Any FK on the database is represent in Java
	* as the actual Entity
	* 
	* BEST PRACTICE
	*/
	/**
	 * G_ID
	 */
	private Genre genre;

	public Band() {}	
	
	public Band(long id, String name, String website, String active, String startDate, String bandHash, Genre genre) {
		this.id = id;
		this.name = name;
		this.website = website;
		this.active = active;
		this.startDate = startDate;
		this.bandHash = bandHash;
		this.genre = genre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getBandHash() {
		return bandHash;
	}

	public void setBandHash(String bandHash) {
		this.bandHash = bandHash;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((bandHash == null) ? 0 : bandHash.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((website == null) ? 0 : website.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Band other = (Band) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (bandHash == null) {
			if (other.bandHash != null)
				return false;
		} else if (!bandHash.equals(other.bandHash))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (website == null) {
			if (other.website != null)
				return false;
		} else if (!website.equals(other.website))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Band [id=" + id + ", name=" + name + ", website=" + website + ", active=" + active + ", startDate="
				+ startDate + ", bandHash=" + bandHash + ", genre=" + genre + "]";
	}

	public int compareTo(Band band) {
		return new Long(this.id).compareTo(band.id);
	}
}
