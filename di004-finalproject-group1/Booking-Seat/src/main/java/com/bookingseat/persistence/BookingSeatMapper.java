package com.bookingseat.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bookingseat.entity.BookingSeat;

public class BookingSeatMapper implements RowMapper<BookingSeat> {

	@Override
	public BookingSeat mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		int seatId = resultSet.getInt("SEATID");
		int basketId = resultSet.getInt("BASKETID");
		
		BookingSeat bookingSeat = new BookingSeat(seatId, basketId);
		return bookingSeat;
	}

}
