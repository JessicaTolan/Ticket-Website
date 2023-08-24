package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;

import com.prisca.entity.Basket;
import com.prisca.model.persistence.BasketDao;


@SpringBootTest
@ActiveProfiles("test")
class BasketApplicationTests {
	@Autowired
    private BasketDao basketDao;
	


   @Test
    void testSaveAndGetBasketByTicketId() {
        Basket basket = new Basket(1, "jEdmonds", 001, 2);
        basketDao.save(basket);

        // Retrieve the basket by ticketId
        Basket retrievedBasket = basketDao.findByTicketId(1);

        // Verify that the correct basket is returned
        assertEquals("jEdmonds", retrievedBasket.getUsername());
        assertEquals(2, retrievedBasket.getQuantity());
    }
 

    @Test
    void testUpdateBasket() {
       
        Basket basket = basketDao.findByTicketId(001);
     

        // Update the quantity
        basket.setQuantity(3);
        basketDao.update(basket);

        // Retrieve the updated basket
        Basket updatedBasket = basketDao.findByTicketId(001);

        // Verify that the basket is updated correctly
        assertEquals(3, updatedBasket.getQuantity());
    }
    
    @Test
    void testUpdateBasketN() {
    	
    	Basket basket = new Basket(6,"test",006,1);
    	
    
        
        assertThrows(EmptyResultDataAccessException.class, () -> basketDao.update(basket));
        
    }

    @Test
    void testDeleteBasket() {
    	 basketDao.deleteBasketById(001);
    	
    }
    
    @Test
    void testDeleteBasketN() {
    	basketDao.deleteBasketById(001);
}
}



