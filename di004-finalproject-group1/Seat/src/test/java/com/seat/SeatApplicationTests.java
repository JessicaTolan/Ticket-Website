package com.seat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;

import com.seat.entity.Seat;
import com.seat.persistence.SeatDao;

@SpringBootTest
@ActiveProfiles("test")
class SeatApplicationTests {
	
	@Autowired
	SeatDao seatDao;
	
	@Test
	void Test_Add_1() {
		Seat seat = new Seat(57,90,"Bristol Hippadrome");
		assertEquals(1, seatDao.addSeat(seat));
	}
	
	@Test
	void Test_Add_2() {
		Seat seat= new Seat(51, 82, "Apollo Theatre");
		assertThrows(DataIntegrityViolationException.class, () -> seatDao.addSeat(seat));
	}

	@Test
	void Test_Delete_1() {
		assertEquals(1, seatDao.deleteSeat(57));
	}
	
	@Test
	void Test_Delete_2() {
		assertEquals(0, seatDao.deleteSeat(562));
	}
	
	@Test
	void Test_View_1() {
		Seat seat= seatDao.getSingleSeat(1);
		assertEquals(67, seat.getSeatNumber());
	}
	
	@Test
	void Test_View_2() {
		assertThrows(EmptyResultDataAccessException.class, () -> seatDao.getSingleSeat(554));
	}
	
	@Test
	void Test_ViewForVenue_1() {
		assertEquals(3, seatDao.getAllSeatsForVenue("Rowan Way").size());
	}
	
	@Test
	void Test_ViewForVenue_2() {
		assertEquals(0,seatDao.getAllSeatsForVenue("Not Real Venue").size());
	}
	
	@Test
	void Test_ViewAll_1() {
		assertEquals(56, seatDao.getAllSeats().size());
	}
	

}
