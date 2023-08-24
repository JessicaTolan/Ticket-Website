package com.venue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;

import com.venue.entity.Venue;
import com.venue.persistence.VenueDao;

@SpringBootTest
@ActiveProfiles("test")
class VenueApplicationTests {

	@Autowired
	VenueDao venueDao;
	
	@Test
	void Test_Add_1() {
		Venue venue = new Venue("Test Venue", 100);
		assertEquals(1, venueDao.addVenue(venue));
	}
	
	@Test
	void Test_Add_2() {
		Venue venue= new Venue("Apollo Theatre",001);
		assertThrows(DataIntegrityViolationException.class, () -> venueDao.addVenue(venue));
	}

	@Test
	void Test_Delete_1() {
		assertEquals(1, venueDao.deleteVenue("Test Venue"));
	}
	
	@Test
	void Test_Delete_2() {
		assertEquals(0, venueDao.deleteVenue("Not a real venue"));
	}
	
	@Test
	void Test_View_1() {
		Venue venue= venueDao.getVenueByName("Apollo Theatre");
		assertEquals(500, venue.getCapacity());
	}
	
	@Test
	void Test_View_2() {
		assertThrows(EmptyResultDataAccessException.class, () -> venueDao.getVenueByName("Not a real Venue"));
	}
	
	@Test
	void Test_Update_1() {
		venueDao.updateVenueCapacity("Manchester Hippadrome", 201);
		Venue venue= venueDao.getVenueByName("Manchester Hippadrome");
		assertEquals(201, venue.getCapacity());
	}
	
	@Test
	void Test_Update_2() {
		assertEquals(0, venueDao.updateVenueCapacity("Not a real Venue", 201));
	}
	
	@Test
	void Test_ViewAll_1() {
		assertEquals(10, venueDao.getAllVenues().size());
	}
	

}
