package com.ticket.persistence;

import java.util.List;

import com.ticket.entity.Ticket;

public interface TicketDao {
//	Add
//	View All
//	View one
//	Search all by price range
//	search all by city
//	update
//	delete
	
	public int addNewTicket(int ticketId, double price, String image, String description, String name, String city, String priceRange, String date, String venue);
	public List<Ticket> viewAllTickets();
	public Ticket viewTicket(int ticketId);
	public List<Ticket> searchTicketsByPriceRange(String priceRange);
	public List<Ticket> searchTicketsByCity(String city);
	public int updateTicket(int ticketId, double price, String description, String name, String city,
			String priceRange, String date, String venue);
	
	public Ticket updateTicket(int ticketId, Ticket ticket);
	public boolean deleteTicket(int ticketId);
}
