package com.prisca.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.prisca.entity.Basket;
import com.prisca.model.persistence.BasketDao;
@Service
public class BasketServiceImpl implements BasketService {
	
	@Autowired
	private BasketDao basketDao;

	@Override
	public List<Basket> getAllBaskets() {
		return basketDao.getAllBaskets();
	}

	@Override
	public Basket getBasketByTicketId(int ticketId) {
		return basketDao.findByTicketId(ticketId);
	}

	@Override
	public boolean addBasket(Basket basket) {
	    try {
	        basketDao.save(basket);
	        return true;
	    } catch (DataAccessException e) {
	        return false;
	    }
	}

	@Override
	public void updateBasket(Basket basket) {
		Basket existingBasket = getBasketByTicketId(basket.getTicketId());
	    if (existingBasket != null) {
	        basketDao.update(basket);
	    }
	}



	
	@Override
	public List<Basket> getBasketsByUsername(String username) {
		return basketDao.getBasketsByUsername(username);
	}

	@Override
	public int deleteBasketById(int ticketId) {
		Basket basket =getBasketByTicketId(ticketId);
		if(basket!=null) {
			return basketDao.deleteBasketById(ticketId);
		}
		return 0;
	}

	
	}


