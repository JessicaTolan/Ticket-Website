package com.ticketfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.web.client.RestTemplate;

import com.ticketfe.entity.Ticket;



public class TicketFEServiceImpl implements TicketFEService{

	@Autowired
	RestTemplate restTemplate;
	
	String baseURL = "http://localhost:8080";
	
	@Override
	public int addNewTicket(int ticketId, double price, String image, String description, String name, String city,
			String priceRange, String date, String venue) {
	
		
		return 0;//restTemplate.postForObject(baseURL + "/tickets" , String.class);
	}

	@Override
	public List<Ticket> viewAllTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket viewTicket(int ticketId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> searchTicketsByPriceRange(String priceRange) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> searchTicketsByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateTicket(int ticketId, double price, String image, String description, String name, String city,
			String priceRange, String date, String venue) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteTicket(int ticketId) {
		// TODO Auto-generated method stub
		return false;
	}

}
