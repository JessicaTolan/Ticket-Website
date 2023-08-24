package com.ticketsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ticketsystem.entity.Basket;
import com.ticketsystem.service.BasketService;

@Controller
public class BasketController {
	 @Autowired
	 BasketService basketService;


	 
	 
	 @GetMapping("/baskets")
	    public ModelAndView getAllBaskets() {
	        List<Basket> baskets = basketService.getAllBaskets();
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("basketList");
	        modelAndView.addObject("baskets", baskets);
	        return modelAndView;
	    }

	    
	    @GetMapping("/baskets/{ticketId}")
	    public ModelAndView getBasketByTicketId(@PathVariable int ticketId) {
	        Basket basket = basketService.getBasketByTicketId(ticketId);
	        ModelAndView modelAndView = new ModelAndView("basketDetails");
	        modelAndView.addObject("basket", basket);
	        return modelAndView;
	    }
	    
	    @GetMapping("/basket-details")
	    public ModelAndView getAllBasketDetails() {
	        List<Basket> allBaskets = basketService.getAllBaskets();
	        ModelAndView modelAndView = new ModelAndView("allBasketDetails");
	        modelAndView.addObject("baskets", allBaskets);
	        return modelAndView;
	    }
	    
	    
	   
	    @RequestMapping("/addToBasket")
	    public ModelAndView inputBasketDetailsPageController() {
	        ModelAndView modelAndView = new ModelAndView();

	        // Add a new Basket object to the model which will be filled with form data
	        modelAndView.addObject("basket", new Basket());

	        // Set the view name to the appropriate form view
	        modelAndView.setViewName("InputBasketDetails");

	        return modelAndView;
	    }



	    //@PostMapping("/baskets/add")
	    //public String addBasket(@RequestBody Basket basket) {
	      //  basketService.addBasket(basket);
	     //   return "redirect:/baskets";
	   // }
	    
	    
	    @PostMapping("/baskets/save")
	    public ModelAndView saveBasketController(@ModelAttribute("basket") Basket basket) {
	        ModelAndView modelAndView = new ModelAndView();
	        String message;

	        // Attempt to save the basket, setting the message based on the result
	        if (basketService.addBasket(basket)) {
	            message = "Basket saved successfully";
	        } else {
	            message = "Basket could not be saved";
	        }

	        // Add the message to the model
	        modelAndView.addObject("message", message);

	        // Set the view name to the appropriate result page
	        modelAndView.setViewName("OutputBasket");

	        return modelAndView;
	    }


	   // @PostMapping("/baskets/update")
		//   public String updateBasket(@RequestParam int ticketId, @RequestParam int quantity) {
		   //    Basket basket = basketService.getBasketByTicketId(ticketId);
		    //    if (basket != null) {
		    //       basket.setQuantity(quantity);
		     //      basketService.updateBasket(basket);
		      //  }
		      //  return "redirect:/baskets";
		   // }
	    
	    @PostMapping("/baskets/update")
	    public String updateBasket(@RequestParam int ticketId, @RequestParam int quantity) {
	        // If the quantity is less than or equal to zero, set it to 1
	        if (quantity <= 0) {
	            quantity = 1;
	        }

	        Basket basket = basketService.getBasketByTicketId(ticketId);
	        if (basket != null) {
	            basket.setQuantity(quantity);
	            basketService.updateBasket(basket);
	        }
	        return "redirect:/baskets";
	    }

	 

		   
		   @GetMapping("/baskets/username")
		    public ModelAndView viewBasketByUsernameForm() {
		        ModelAndView modelAndView = new ModelAndView("viewBasketByUsernameForm");
		        return modelAndView;
		    }

		    @PostMapping("/baskets/username")
		    public ModelAndView viewBasketByUsername(@RequestParam String username) {
		        List<Basket> baskets = basketService.getBasketsByUsername(username);
		        ModelAndView modelAndView = new ModelAndView("viewBasketByUsername");
		        modelAndView.addObject("username", username);
		        modelAndView.addObject("baskets", baskets);
		        return modelAndView;
		    }
		    
			
	    
		    @RequestMapping("/baskets/InputTicketIdDelete")
		   public ModelAndView inputTicketIDForDeleteController() {
		       return new ModelAndView("InputTicketIdForDelete", "deleteBasket", new Basket());
		    }

		    @RequestMapping("/baskets/deleteBasket")
		    public ModelAndView deleteBasketController( @ModelAttribute("deleteBasket") Basket basket) {
		        ModelAndView modelAndView = new ModelAndView();
		        String message = null;
		        int tId = basket.getTicketId();

		        if (basketService.deleteBasketById(tId) > 0) {
		            message = "Basket with id " + tId + " deleted !";
		        } else {
		           message = "Basket with id " + tId + " not deleted !";
		       }
		        
		       modelAndView.addObject("message", message);
		       modelAndView.setViewName("Output");

		        return modelAndView;
		    }
	    
}
