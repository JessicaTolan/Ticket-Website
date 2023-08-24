package com.venue.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.venue.entity.Venue;

public class VenueMapper implements RowMapper<Venue> {

	@Override
	public Venue mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		String venueName = resultSet.getString("VENUENAME");
		int capacity = resultSet.getInt("CAPACITY");
		
		Venue venue = new Venue(venueName,capacity);
		return venue;
	}

}
