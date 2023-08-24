package com.ticketsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ticketsystem.entity.Ticket;
import com.ticketsystem.entity.TicketList;
@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	String baseURL = "http://localhost:8092/";

	@Override
	public Ticket addNewTicket(int ticketId, double price, String image, String description, String name, String city,
			String priceRange, String date, String venue) {
		// TODO Auto-generated method stub
		
		Ticket ticket = new Ticket(ticketId, price,image, description, name, city, priceRange, date, venue);
		restTemplate.postForEntity(baseURL+"tickets", ticket, Ticket.class);
		
		return ticket;
	}

	@Override
	public List<Ticket> viewAllTickets() {
		TicketList ticketList = restTemplate.getForObject(baseURL + "tickets", TicketList.class);
		 List<Ticket> list = ticketList.getTicketList();
		return list;
	}

	@Override
	public Ticket viewTicket(int ticketId) {
		Ticket ticket = restTemplate.getForObject(baseURL+"tickets/ticketId/"+ticketId, Ticket.class);
		return ticket;
	}

	@Override
	public List<Ticket> searchTicketsByPriceRange(String priceRange) {
		TicketList ticketList = restTemplate.getForObject(baseURL+"tickets/priceRange/"+priceRange, TicketList.class);
		List<Ticket> list = ticketList.getTicketList();
		return list;
	}

	@Override
	public List<Ticket> searchTicketsByCity(String city) {
		TicketList ticketList = restTemplate.getForObject(baseURL+"tickets/city/"+city, TicketList.class);
		List<Ticket> list = ticketList.getTicketList();
		return list;
	}

	@Override
	public Ticket updateTicket(int ticketId, double price, String description, String name, String city,
			String priceRange, String date, String venue) {
		
//		Ticket ticket = new Ticket(ticketId, price,image, description, name, city, priceRange, date, venue);
//		restTemplate.put(baseURL+"tickets"+ "/" +ticketId + "/" +price + "/" + image + "/" +  description + "/" + name+ "/" + city + "/" + priceRange, ticket, Ticket.class);
		Ticket ticket = viewTicket(ticketId);
		ticket.setTicketId(ticketId);
		ticket.setPrice(price);
		ticket.setCity(city);
		ticket.setDate(date);
		ticket.setDescription(description);
		ticket.setName(name);
		ticket.setPriceRange(priceRange);
		ticket.setVenue(venue);
		//Ticket ticket = new Ticket(ticketId, price, description, name, city, priceRange, date, venue);
		restTemplate.put(baseURL+"tickets"+ "/" +ticketId + "/" +price  + "/" +  description + "/" + name+ "/" + city + "/" + priceRange+ "/" + date + "/" + venue, ticket, Ticket.class);
		
		return ticket;
	}

	@Override
	public boolean deleteTicket(int ticketId) {
		
		if(restTemplate.getForObject(baseURL+"tickets/ticketId/"+ticketId, Ticket.class) != null) {
			restTemplate.delete(baseURL+"tickets/"+ticketId);
			return true;
		}
		else
			return false;
	}

	@Override
	public Ticket updateTicket(int ticketId, Ticket ticket) {
		restTemplate.put(baseURL+"tickets/update/"+ticketId, ticket, Ticket.class);
		return ticket;
	}

}
