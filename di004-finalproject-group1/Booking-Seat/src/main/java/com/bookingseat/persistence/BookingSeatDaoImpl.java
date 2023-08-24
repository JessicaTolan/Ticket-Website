package com.bookingseat.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bookingseat.entity.BookingSeat;
@Repository
public class BookingSeatDaoImpl implements BookingSeatDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int addBookingSeat(BookingSeat bookingSeat) {
		String query = "insert into booking_seat values(?,?)";
		return jdbcTemplate.update(query,bookingSeat.getSeatId(),bookingSeat.getBasketId());
	}

	@Override
	public List<BookingSeat> getAllBookedSeats() {
		String query = "SELECT * FROM BOOKING_SEAT";
		return jdbcTemplate.query(query, new BookingSeatMapper());
	}

	@Override
	public BookingSeat getSingleBookingSeat(int seatId, int basketId) {
		String query = "SELECT * FROM BOOKING_SEAT WHERE SEATID = "+seatId+" AND BASKETID ="+basketId;
		return jdbcTemplate.queryForObject(query,new BookingSeatMapper());
	}

	
}
