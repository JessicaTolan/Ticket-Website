package com.ticket.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ticket.entity.Ticket;
import com.ticket.entity.TicketRowMapper;

@Repository
public class TicketDaoImpl implements TicketDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int addNewTicket(int ticketId, double price, String image, String description, String name, String city,
			String priceRange, String date, String venue) {
		try {
			return jdbcTemplate.update("INSERT INTO TICKET VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)",ticketId, price, image, description, name, city, priceRange, date, venue);
		}catch(Exception e) {
			return 0;
		}
	}

	@Override
	public List<Ticket> viewAllTickets() {
		
		return jdbcTemplate.query("SELECT * FROM TICKET", new TicketRowMapper());
	}

	@Override
	public Ticket viewTicket(int ticketId) {
		
		try {
		
			return jdbcTemplate.queryForObject("SELECT * FROM TICKET WHERE TICKETID = ?", new TicketRowMapper(), ticketId);
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<Ticket> searchTicketsByPriceRange(String priceRange) {
		
		return jdbcTemplate.query("SELECT * FROM TICKET WHERE PRICERANGE = ?", new TicketRowMapper(), priceRange);
	}

	@Override
	public List<Ticket> searchTicketsByCity(String city) {
		
		return jdbcTemplate.query("SELECT * FROM TICKET WHERE CITY = ?", new TicketRowMapper(), city);
	}

	@Override
	public int updateTicket(int ticketId, double price,  String description, String name, String city,
			String priceRange, String date, String venue) {
		try {
			return jdbcTemplate.update("UPDATE TICKET SET PRICE = ?, DESCRIPTION = ?, NAME = ?, CITY = ?, PRICERANGE = ?, DATE = ?, VENUE = ? WHERE TICKETID=?", price, description, name, city,
					priceRange, ticketId, date, venue);
		}catch(Exception e) {
			return 0;
		}
	}

	@Override
	public boolean deleteTicket(int ticketId) {
		
		try {
			int value = jdbcTemplate.update("DELETE FROM TICKET WHERE TICKETID = ?", ticketId);
			if(value ==1) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
	
			return false;
		}
	}

	@Override
	public Ticket updateTicket(int ticketId, Ticket ticket) {
		try {
			jdbcTemplate.update("UPDATE TICKET SET PRICE = ?, DESCRIPTION = ?, IMAGE = ? ,NAME = ?, CITY = ?, PRICERANGE = ?, DATE = ?, VENUE = ? WHERE TICKETID=?", ticket.getPrice(), ticket.getDescription(), ticket.getImage(),ticket.getName(), ticket.getCity(),
					ticket.getPrice(), ticket.getDate(), ticket.getVenue(), ticketId);
			
			Ticket updatedTicket = viewTicket(ticketId);
			return updatedTicket;
		}catch(Exception e) {
			return null;
		}
	}

}
