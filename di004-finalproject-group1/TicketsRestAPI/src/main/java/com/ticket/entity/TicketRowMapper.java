package com.ticket.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TicketRowMapper implements RowMapper<Ticket> {

	@Override
	public Ticket mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Ticket ticket = new Ticket();
		
		ticket.setTicketId(resultSet.getInt("ticketId"));
		ticket.setPrice(resultSet.getDouble("price"));
		ticket.setImage(resultSet.getString("image"));
		ticket.setDescription(resultSet.getString("description"));
		ticket.setName(resultSet.getString("name"));
		ticket.setCity(resultSet.getString("city"));
		ticket.setPriceRange(resultSet.getString("priceRange"));
		ticket.setDate(resultSet.getString("DATE"));
		ticket.setVenue(resultSet.getString("VENUE"));
		
		return ticket;
	}

}
