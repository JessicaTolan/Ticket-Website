package com.reviews.entity;

import java.util.List;

public class ReviewList {
	List<Review> reviews;

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public ReviewList(List<Review> reviews) {
		super();
		this.reviews = reviews;
	}

	public ReviewList() {
		super();
	}
	
}
