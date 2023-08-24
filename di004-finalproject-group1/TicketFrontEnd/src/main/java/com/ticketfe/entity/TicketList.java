package com.ticketfe.entity;

import java.util.List;

import com.ticket.entity.Ticket;

public class TicketList {
	
private List<Ticket> ticketList;
	

	public TicketList(List<Ticket> ticketList) {
		super();
		this.ticketList = ticketList;
	}

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

}
