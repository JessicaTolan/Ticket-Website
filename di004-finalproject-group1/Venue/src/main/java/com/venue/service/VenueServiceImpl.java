package com.venue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venue.entity.Venue;
import com.venue.persistence.VenueDao;

@Service
public class VenueServiceImpl implements VenueService {

	@Autowired
	VenueDao venueDao;
	
	@Override
	public int addVenue(Venue venue) {
		try {
			return venueDao.addVenue(venue);
			}
			catch(Exception ex) {
				return 0;
			}
	}

	@Override
	public int deleteVenue(String venueName) {
		Venue venue= getVenueByName(venueName);
		if(venue!=null) {
			return venueDao.deleteVenue(venueName);
		}
		return 0;
	}

	@Override
	public int updateVenueCapacity(String venueName, int capacity) {
		return venueDao.updateVenueCapacity(venueName, capacity);
	}

	@Override
	public List<Venue> getAllVenues() {
		return venueDao.getAllVenues();
	}

	@Override
	public Venue getVenueByName(String venueName) {
		try {
			return venueDao.getVenueByName(venueName);
			}
			catch(Exception ex) {
				return null;
			}
	}

}
