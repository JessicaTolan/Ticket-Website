package com.prisca.model.persistence;

import java.util.List;

import com.prisca.entity.Basket;

public interface BasketDao {
	List<Basket> getAllBaskets();
	Basket findByTicketId(int ticketId);
	List<Basket> getBasketsByUsername(String username);
	void save(Basket basket);
	void update(Basket basket);
	public int deleteBasketById(int ticketId);
}
