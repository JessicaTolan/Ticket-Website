package com.ticket;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.ticket.entity.Ticket;
import com.ticket.persistence.TicketDao;

@SpringBootTest
@ActiveProfiles("test")
public class TicketDaoTests {
	
	
	@Autowired
	TicketDao ticketdao;
	
	@Test
    void addNewTicketTest1() {
		

		if(ticketdao.viewTicket(11) == null) {
    	
			assertEquals(1, ticketdao.addNewTicket(11,45.50, null, null, "Test", null, null, null, null));
		}else {
			
			ticketdao.deleteTicket(11);
			assertEquals(1, ticketdao.addNewTicket(11,45.50, null, null, "Test", null, null, null, null));
		}
        
    }
	
	@Test
    void addNewTicketTest2() {
    	
		assertEquals(0, ticketdao.addNewTicket(11,45.50, null, null, "Test", null, null, null, null));
        
    }
	
	@Test
    void viewAllTicketsTest() {
    	
		assertEquals(11, ticketdao.viewAllTickets().size());
        
    }
	
	@Test
    void viewTicketTest1() {
	
		assertNotNull(ticketdao.viewTicket(3));
        
    }
	
	void viewTicketTest2() {
		
		assertNull(ticketdao.viewTicket(23));
        
    }
	
	@Test
    void searchTicketsByCity1() {
	
		assertEquals(5, ticketdao.searchTicketsByCity("London").size());
        
    }
	
	@Test
    void searchTicketsByCity2() {
	
		assertEquals(0, ticketdao.searchTicketsByCity("Austrailia").size());
        
    }
	
	@Test
    void searchTicketsByPriceRange1() {
	
		assertEquals(3, ticketdao.searchTicketsByPriceRange("£20-£30").size());
        
    }
	
	@Test
    void searchTicketsByPriceRange2() {
	
		assertEquals(0, ticketdao.searchTicketsByPriceRange("£100-200").size());
        
    }
	
	@Test
    void updateTicket1() {

		
		ticketdao.updateTicket(3, 30,  "AMAZING!", "Little Mermaid", "Birmingham", "10-20", null, null);
	
		Ticket ticket = ticketdao.viewTicket(3);
		
		String expectedAnswer ="3,30.0,https://upload.wikimedia.org/wikipedia/en/7/70/Tina_musical_poster.png,AMAZING!,Little Mermaid,Birmingham,10-20";
		String actualAnswer = Integer.toString(ticket.getTicketId()) + "," +Double.toString(ticket.getPrice()) + "," + ticket.getImage()+ "," + ticket.getDescription() +"," + ticket.getName() +"," + ticket.getCity()+","+ticket.getPriceRange();
		
		ticketdao.updateTicket(3, 23.95,  "AMAZING! The best soundtrack you will hear all year", "Tina: The Tina Turner Musical", "London", "£20-£30", null, null);
		assertEquals(expectedAnswer, actualAnswer);
		
        
    }
	
	@Test
    void deleteTicketTest1() {
		
		ticketdao.addNewTicket(12,45.50, null, null, "Test", null, null, null, null);
    	
		assertTrue(ticketdao.deleteTicket(12));
        
    }
	
	@Test
    void deleteTicketTest2() {
    	
		assertFalse(ticketdao.deleteTicket(14));
        
    }
	
	
	
	

}
