package com.ticketsystem.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.ticketsystem.entity.Basket;

@Service
public class BasketServiceImpl implements BasketService {
	 @Autowired
	    private RestTemplate restTemplate;

	    private final String basketApiUrl = "http://localhost:8082/baskets/";

	@Override
	public List<Basket> getAllBaskets() {
		Basket[] baskets = restTemplate.getForObject(basketApiUrl, Basket[].class);
        return Arrays.asList(baskets);
	}

	@Override
	public Basket getBasketByTicketId(int ticketId) {
		return restTemplate.getForObject(basketApiUrl + ticketId, Basket.class);
	}

	@Override
	public boolean addBasket(Basket basket) {
		 try {
		        restTemplate.postForObject(basketApiUrl, basket, Basket.class);
		        return true;
		    } catch (RestClientException e) {
		        return false;
		    }
	}

	@Override
	public void updateBasket(Basket basket) {
		restTemplate.put(basketApiUrl + basket.getTicketId(), basket);

	}



	@Override
	public List<Basket> getBasketsByUsername(String username) {
		String url = basketApiUrl + "username/" + username;
		Basket[] basketsArray = restTemplate.getForObject(url, Basket[].class);
		return Arrays.asList(basketsArray);
	}

	@Override
	public int deleteBasketById(int ticketId) {
		try {
			restTemplate.delete(basketApiUrl+"deleteBasket/"+ticketId);
			return 1;
		} catch(NotFound e  ) {
			return 0;
		}
		
		
	}
	}


