package com.seat.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.seat.entity.Seat;

public class SeatMapper implements RowMapper<Seat> {

	@Override
	public Seat mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		int seatId = resultSet.getInt("SEATID");
		int seatNumber = resultSet.getInt("SEATNUMBER");
		String venueName = resultSet.getString("VENUENAME");
		
		Seat seat = new Seat(seatId, seatNumber, venueName);
		return seat;
	}

}
