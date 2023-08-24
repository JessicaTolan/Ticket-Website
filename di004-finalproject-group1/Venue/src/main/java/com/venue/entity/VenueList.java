package com.venue.entity;

import java.util.List;

public class VenueList {
	List<Venue> venues;

	public VenueList(List<Venue> venues) {
		super();
		this.venues = venues;
	}

	public VenueList() {
		super();
	}

	public List<Venue> getVenues() {
		return venues;
	}

	public void setVenues(List<Venue> venues) {
		this.venues = venues;
	}
	
	
}
