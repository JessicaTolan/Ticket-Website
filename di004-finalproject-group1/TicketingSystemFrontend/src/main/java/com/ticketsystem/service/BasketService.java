package com.ticketsystem.service;

import java.util.List;

import com.ticketsystem.entity.Basket;

public interface BasketService {
	List<Basket> getAllBaskets();
    Basket getBasketByTicketId(int ticketId);
    List<Basket> getBasketsByUsername(String username);
    boolean addBasket(Basket basket);
    void updateBasket(Basket basket);
	public int deleteBasketById(int ticketId);

}
