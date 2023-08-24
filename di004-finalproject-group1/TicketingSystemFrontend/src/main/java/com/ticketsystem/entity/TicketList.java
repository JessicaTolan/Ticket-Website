package com.ticketsystem.entity;

import java.util.List;

public class TicketList {
	
	private List<Ticket> ticketList;
	

	public TicketList(List<Ticket> ticketList) {
		super();
		this.ticketList = ticketList;
	}

	public TicketList() {
		super();
	}

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

}
