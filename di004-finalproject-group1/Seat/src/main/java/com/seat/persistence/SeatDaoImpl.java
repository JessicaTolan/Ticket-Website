package com.seat.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seat.entity.Seat;

@Repository
public class SeatDaoImpl implements SeatDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int addSeat(Seat seat) {
		String query = "insert into seat values(?,?,?)";
		return jdbcTemplate.update(query,seat.getSeatId(),seat.getSeatNumber(), seat.getVenueName());
	}

	@Override
	public int deleteSeat(int seatId) {
		String query = "DELETE FROM SEAT WHERE SEATID = ?";
		return jdbcTemplate.update(query, seatId);
	}

	@Override
	public List<Seat> getAllSeats() {
		String query = "SELECT * FROM SEAT";
		return jdbcTemplate.query(query, new SeatMapper());
	}

	@Override
	public List<Seat> getAllSeatsForVenue(String venueName) {
		String query = "SELECT * FROM SEAT WHERE VENUENAME = '"+venueName+"';";
		return jdbcTemplate.query(query,new SeatMapper());
	}

	@Override
	public Seat getSingleSeat(int seatId) {
		String query = "SELECT * FROM Seat WHERE SEATID = "+seatId;
		return jdbcTemplate.queryForObject(query,new SeatMapper());
	}

}
