package com.ticketsystem.service;

import java.util.List;

import com.ticketsystem.entity.Ticket;


public interface TicketService {
	
	public Ticket addNewTicket(int ticketId, double price, String image, String description, String name, String city, String priceRange, String date, String venue);
	public List<Ticket> viewAllTickets();
	public Ticket viewTicket(int ticketId);
	public List<Ticket> searchTicketsByPriceRange(String priceRange);
	public List<Ticket> searchTicketsByCity(String city);
	public Ticket updateTicket(int ticketId, double price, String description, String name, String city,
			String priceRange, String date, String venue);
	
	public Ticket updateTicket(int ticketId, Ticket ticket);
	public boolean deleteTicket(int ticketId);

}
