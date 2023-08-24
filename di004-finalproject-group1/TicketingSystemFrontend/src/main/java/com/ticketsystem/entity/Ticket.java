package com.ticketsystem.entity;

public class Ticket{
	

		private int ticketId;
		private double price;
		private String image, description, name, city, priceRange, date, venue;
		
		public Ticket() {
		}
		
		
		public Ticket(int ticketId, double price, String image, String description, String name, String city,
				String priceRange, String date, String venue) {
			super();
			this.ticketId = ticketId;
			this.price = price;
			this.image = image;
			this.description = description;
			this.name = name;
			this.city = city;
			this.priceRange = priceRange;
			this.date = date;
			this.venue = venue;
		}
		
		public Ticket(int ticketId, double price, String description, String name, String city,
				String priceRange, String date, String venue) {
			super();
			this.ticketId = ticketId;
			this.price = price;
			this.description = description;
			this.name = name;
			this.city = city;
			this.priceRange = priceRange;
			this.date = date;
			this.venue = venue;
		}
		public int getTicketId() {
			return ticketId;
		}
		public void setTicketId(int ticketId) {
			this.ticketId = ticketId;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getPriceRange() {
			return priceRange;
		}
		public void setPriceRange(String priceRange) {
			this.priceRange = priceRange;
		}


		public String getDate() {
			return date;
		}


		public void setDate(String date) {
			this.date = date;
		}


		public String getVenue() {
			return venue;
		}


		public void setVenue(String venue) {
			this.venue = venue;
		}
	
}

