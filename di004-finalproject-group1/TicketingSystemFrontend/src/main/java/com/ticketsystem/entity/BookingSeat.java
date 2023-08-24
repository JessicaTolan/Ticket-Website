package com.ticketsystem.entity;

public class BookingSeat {
	private int seatId;
	private int basketId;
	public BookingSeat(int seatId, int basketId) {
		super();
		this.seatId = seatId;
		this.basketId = basketId;
	}
	public BookingSeat() {
		super();
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public int getBasketId() {
		return basketId;
	}
	public void setBasketId(int basketId) {
		this.basketId = basketId;
	}
	@Override
	public String toString() {
		return "BookingSeat [seatId=" + seatId + ", basketId=" + basketId + "]";
	}
	
	
}
