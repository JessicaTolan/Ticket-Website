package com.prisca.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prisca.entity.Basket;
import com.prisca.model.service.BasketService;

@RestController
public class BasketResource {
	 @Autowired
	 private BasketService basketService;

	    @GetMapping(path = "/baskets", produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Basket> getAllBaskets() {
	        return basketService.getAllBaskets();
	    }

	    @GetMapping(path = "/baskets/{ticketId}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public Basket getBasketByTicketId(@PathVariable int ticketId) {
	        return basketService.getBasketByTicketId(ticketId);
	    }
	    
	    @GetMapping(path = "/baskets/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Basket> getBasketsByUsername(@PathVariable String username) {
	        return basketService.getBasketsByUsername(username);
	    
	   }

	    @PostMapping(path = "/baskets", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public void addBasket(@RequestBody Basket basket) {
	        basketService.addBasket(basket);
	    }

	    @PutMapping(path = "/baskets/{ticketId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public void updateBasket(@PathVariable int ticketId, @RequestBody Basket basket) {
	        basket.setTicketId(ticketId);
	        basketService.updateBasket(basket);
	    }

	    @DeleteMapping(path = "/baskets/deleteBasket/{ticketId}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public void deleteBasket(@PathVariable int ticketId) {
	        basketService.deleteBasketById(ticketId);
	    }
	
	

}
