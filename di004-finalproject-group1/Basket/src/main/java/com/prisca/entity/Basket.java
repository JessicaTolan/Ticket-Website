package com.prisca.entity;

public class Basket {
	private int basketId;
	private String username;
    private int ticketId;
    private int quantity;

   public  Basket() {
	   
   }

public Basket(int basketId, String username, int ticketId, int quantity) {
	super();
	this.basketId = basketId;
	this.username = username;
	this.ticketId = ticketId;
	this.quantity = quantity;
}

public int getBasketId() {
	return basketId;
}

public void setBasketId(int basketId) {
	this.basketId = basketId;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public int getTicketId() {
	return ticketId;
}

public void setTicketId(int ticketId) {
	this.ticketId = ticketId;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

@Override
public String toString() {
	return "Basket [basketId=" + basketId + ", username=" + username + ", ticketId=" + ticketId + ", quantity="
			+ quantity + "]";
}
   
   

}