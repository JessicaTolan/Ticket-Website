package com.venue.service;

import java.util.List;

import com.venue.entity.Venue;

public interface VenueService {
	public int addVenue(Venue venue);
	public int deleteVenue(String venueName);
	public int updateVenueCapacity(String venueName, int capacity);
	public List<Venue> getAllVenues();
	public Venue getVenueByName(String venueName);
}
