package com.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.entity.Ticket;
import com.ticket.entity.TicketList;
import com.ticket.service.TicketService;

@RestController
public class TicketController {

	@Autowired
	TicketService ticketService;
	
	@CrossOrigin
	@GetMapping(path = "/tickets/ticketId/{ticketId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ticket> viewTicket(@PathVariable("ticketId") int ticketId) {;
		ResponseEntity response=null;
		Ticket ticket = ticketService.viewTicket(ticketId);
		if(ticket != null)
			response=new ResponseEntity<Ticket>(ticket, HttpStatus.FOUND);
		else
			response=new ResponseEntity<Ticket>(ticket,HttpStatus.NOT_FOUND);
		return response;
	}
	
	@CrossOrigin
	@GetMapping(path="/tickets",produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<TicketList> viewAllTickets() {
		TicketList ticketList= new TicketList(ticketService.viewAllTickets());
		if(ticketList.getTicketList().size()>0)
			return new ResponseEntity<TicketList>(ticketList,HttpStatus.OK);
		else
			return new ResponseEntity<TicketList>(ticketList,HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(path = "/tickets",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Ticket addNewTicket(@RequestBody Ticket ticket) {
		if(ticketService.addNewTicket(ticket.getTicketId(), ticket.getPrice(), ticket.getImage(), ticket.getDescription(), ticket.getName(), ticket.getCity(), ticket.getPriceRange(), ticket.getDate(), ticket.getVenue()) != 0)
			return ticket;
		else
			return null;
	}
	
	@CrossOrigin
	@GetMapping(path = "/tickets/priceRange/{priceRange}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TicketList> searchTicketsByPriceRange(@PathVariable("priceRange") String priceRange) {
		TicketList ticketList = new TicketList(ticketService.searchTicketsByPriceRange(priceRange));
		ResponseEntity response=null;
		if(ticketList.getTicketList().size()>0)
			return new ResponseEntity<TicketList>(ticketList,HttpStatus.OK);
		else
			return new ResponseEntity<TicketList>(ticketList,HttpStatus.NO_CONTENT);
	}
	
	@CrossOrigin
	@GetMapping(path = "/tickets/city/{city}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TicketList> searchTicketsByCity(@PathVariable("city") String city) {
		TicketList ticketList = new TicketList(ticketService.searchTicketsByCity(city));
		ResponseEntity response=null;
		if(ticketList.getTicketList().size()>0)
			return new ResponseEntity<TicketList>(ticketList,HttpStatus.OK);
		else
			return new ResponseEntity<TicketList>(ticketList,HttpStatus.NO_CONTENT);
	}
	
	
//	@PutMapping(path = "/tickets/{ticketId}/{price}/{description}/{name}/{city}/{priceRange}/{date}/{venue}",produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Ticket> updateTicket(@PathVariable("ticketId") int ticketId,@PathVariable("price") double price,  @PathVariable("description") String description, @PathVariable("name") String name, @PathVariable("city") String city, @PathVariable("priceRange") String priceRange, @PathVariable("date")String date, @PathVariable("venue")String venue){
//		 
//		
//		
//		if(ticketService.updateTicket(ticketId, price,  description, name, city, priceRange, date, venue)==1) {
//			
//			//Ticket ticket = new Ticket(ticketId, price, description, name, city, priceRange, date, venue);
//			Ticket ticket = ticketService.viewTicket(ticketId);
//			ticket.setTicketId(ticketId);
//			ticket.setPrice(price);
//			ticket.setCity(city);
//			ticket.setDate(date);
//			ticket.setDescription(description);
//			ticket.setName(name);
//			ticket.setPriceRange(priceRange);
//			ticket.setVenue(venue);
//			return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
//		}
//		else
//			return new ResponseEntity<Ticket>(HttpStatus.BAD_REQUEST);
//			
//	}
	
	@PutMapping(path = "/tickets/update/{ticketId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ticket> updateTicket(@PathVariable("ticketId")int ticketId, @RequestBody Ticket ticket) {
		 
		
		
		if(ticketService.viewTicket(ticketId) != null) {
			
			Ticket updatedTicket = ticketService.updateTicket(ticketId, ticket);
			
			return new ResponseEntity<Ticket>(updatedTicket, HttpStatus.OK);
		}
		else
			return new ResponseEntity<Ticket>(HttpStatus.BAD_REQUEST);
			
	}
	
	@DeleteMapping(path = "/tickets/{ticketId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ticket> deleteEmployeeResource(@PathVariable("ticketId") int ticketId) {
		boolean isDeleted = ticketService.deleteTicket(ticketId);
		if(isDeleted)
			return new ResponseEntity<Ticket>(HttpStatus.OK);
		else
			return new ResponseEntity<Ticket>(HttpStatus.NO_CONTENT);
	}
	
	
}
