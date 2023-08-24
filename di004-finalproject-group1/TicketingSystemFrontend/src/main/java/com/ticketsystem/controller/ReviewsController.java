package com.ticketsystem.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ticketsystem.entity.Review;
import com.ticketsystem.entity.Ticket;
import com.ticketsystem.service.ReviewService;
import com.ticketsystem.service.TicketService;

@RestController
public class ReviewsController {
	
	@Autowired
	ReviewService reviewService;

	@Autowired
	TicketService ticketService;
	
	
	@ModelAttribute("ticketIds")
	public List<Integer> getTicketId(){
		return ticketService.viewAllTickets()
				.stream()
				.map(tick-> tick.getTicketId())
				.collect(Collectors.toList());
	}
	
	@ModelAttribute("nextId")
	public int getIdForReview() {
		List<Integer> ids = reviewService.getAllReviews()
		.stream().map(review -> review.getReviewId()).collect(Collectors.toList());
		int newId = Collections.max(ids) +1;
		return newId;
	}
	
	@RequestMapping("/InputReviewIDPage")
	public ModelAndView InputReviewIdPageController() {
		return new ModelAndView("InputReviewID");
	}
	
	@RequestMapping("/InputReviewShowIDPage")
	public ModelAndView InputReviewShowIdPageController() {
		return new ModelAndView("InputReviewShowID");
	}

	@RequestMapping("/searchReviewById")
	public ModelAndView searchReviewByIdController(@RequestParam("reviewId") int reviewId) {
		ModelAndView modelAndView = new ModelAndView();
		Review review = reviewService.getReviewById(reviewId);
		if (review != null) {
			modelAndView.addObject("review", review);
			modelAndView.setViewName("ShowReview");
		} else {
			modelAndView.addObject("message", "Review with ID " + reviewId + " does not exist");
			modelAndView.setViewName("Output");

		}

		return modelAndView;
	}

	@RequestMapping("/searchReviewByShowId")
	public ModelAndView searchReviewByIdShowController(@RequestParam("ticketId") int ticketId) {
		ModelAndView modelAndView = new ModelAndView();
		List<Review> reviewList = reviewService.getAllReviewsForAShow(ticketId);
		if (reviewList != null) {
			modelAndView.addObject("reviewList", reviewList);
			modelAndView.setViewName("DisplayAllReviews");
		} else {
			modelAndView.addObject("message", "Show with ID " + ticketId + " does not have any reviews");
			modelAndView.setViewName("Output");

		}

		return modelAndView;
	}
	
	@RequestMapping("/InputReviewDetails")
	public ModelAndView InputReviewDetailsPageController() {
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.addObject("newReview", new Review());
		modelAndView.setViewName("InputReviewDetails");
		return modelAndView;
	}

	@RequestMapping("/showAllReviews")
	public ModelAndView showAllReviewsController() {
		ModelAndView modelAndView = new ModelAndView();
		List<Review> reviewList = reviewService.getAllReviews();
		modelAndView.addObject("reviewList", reviewList);
		modelAndView.setViewName("DisplayAllReviews");
		return modelAndView;
	}

	@RequestMapping("/saveReview")
	public ModelAndView saveReviewController(@ModelAttribute("newReview") Review review) {
		ModelAndView modelAndView = new ModelAndView();
		String message = null;
		review.setReviewId(getIdForReview());
		if (reviewService.addReview(review) !=null)
			message = "Review Added";
		else
			message = "Review Not Added";

		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");

		return modelAndView;
	}

	@RequestMapping("/InputReviewIDDelete")
	public ModelAndView inputReviewIDForDeleteController() {
		return new ModelAndView("InputReviewIdForDelete","deleteReview",new Review());
	}

	@RequestMapping("/deleteReview")
	public ModelAndView deleteReviewController(@ModelAttribute("deleteReview") Review review) {
		ModelAndView modelAndView = new ModelAndView();
		String message = null;
		int rId=review.getReviewId();
		if (reviewService.deleteReviewById(rId) >0) {
			message = "Review with id " + rId + " deleted !";
		} else {
			message = "Review with id " + rId + " not deleted !";
		}
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		
		return modelAndView;
	}
	
	@RequestMapping("/InputReviewDetailsForUpdate")
	public ModelAndView InputReviewDetailsForUpdateController(){
		return new ModelAndView("InputReviewDetailsForUpdate");
	}
	
	
	@RequestMapping("/updateReview")
	public ModelAndView updateReviewSalaryController(@RequestParam("rId") int reviewId, @RequestParam("reviewText") String review) {	
		String message=null;	
		if(reviewService.updateReview(reviewId, review) !=null)
			message="Review "+reviewId+" edited! Thanks for updating your review";
		else
			message="Review "+reviewId+" was not edited. Something went wrong";
		
		return new ModelAndView("Output", "message", message);
	}
	
}
