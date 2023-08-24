package com.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.entity.Ticket;
import com.ticket.persistence.TicketDao;
import com.ticket.persistence.TicketDaoImpl;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	TicketDao ticketDao;

	@Override
	public int addNewTicket(int ticketId, double price, String image, String description, String name, String city,
			String priceRange, String date, String venue) {
		
		return ticketDao.addNewTicket(ticketId, price, image, description, name, city, priceRange, date, venue);
	}

	@Override
	public List<Ticket> viewAllTickets() {
		
		return ticketDao.viewAllTickets();
	}

	@Override
	public Ticket viewTicket(int ticketId) {
		
		return ticketDao.viewTicket(ticketId);
	}

	@Override
	public List<Ticket> searchTicketsByPriceRange(String priceRange) {
		
		return ticketDao.searchTicketsByPriceRange(priceRange);
	}
	

	@Override
	public List<Ticket> searchTicketsByCity(String city) {
		
		return ticketDao.searchTicketsByCity(city);
	}

	@Override
	public int updateTicket(int ticketId, double price,  String description, String name, String city,
			String priceRange, String date, String venue) {
		
		return ticketDao.updateTicket(ticketId, price,  description, name, city, priceRange, date, venue);
	}

	@Override
	public boolean deleteTicket(int ticketId) {
		
		return ticketDao.deleteTicket(ticketId);
	}

	@Override
	public Ticket updateTicket(int ticketId, Ticket ticket) {
		
		return ticketDao.updateTicket(ticketId, ticket);
	}

}
