package com.reviews.entity;

public class Review {
	
	
	private String username;
	private String review;
	private int ticketId;
	private int reviewId;
	
	public Review(String username, String review, int ticketId, int reviewId) {
		super();
		this.username = username;
		this.review = review;
		this.ticketId = ticketId;
		this.reviewId = reviewId;
	}
	public Review() {
		super();
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	@Override
	public String toString() {
		return "Reviews [reviewId=" + reviewId + ", username=" + username + ", review=" + review + ", ticketId="
				+ ticketId + "]";
	}
	
	
}
