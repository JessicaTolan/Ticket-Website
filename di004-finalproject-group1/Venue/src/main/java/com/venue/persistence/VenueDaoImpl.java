package com.venue.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.venue.entity.Venue;
@Repository
public class VenueDaoImpl implements VenueDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int addVenue(Venue venue) {
		String query = "insert into venue values(?,?)";
		return jdbcTemplate.update(query, venue.getVenueName(), venue.getCapacity());
	}

	@Override
	public int deleteVenue(String venueName) {
		String query = "DELETE FROM VENUE WHERE VENUENAME = ?";
		return jdbcTemplate.update(query, venueName);
	}

	@Override
	public int updateVenueCapacity(String venueName, int capacity) {
		String query = "update venue set capacity = '"+capacity+"' where venueName = '" + venueName+"';";
		return jdbcTemplate.update(query);
	}

	@Override
	public List<Venue> getAllVenues() {
		String query = "SELECT * FROM VENUE";
		return jdbcTemplate.query(query, new VenueMapper());
	}

	@Override
	public Venue getVenueByName(String venueName) {
		String query = "SELECT * FROM VENUE WHERE VENUENAME = '"+venueName+"';";
		return jdbcTemplate.queryForObject(query,new VenueMapper());
	}

}
