package com.hotel_review.hotel.exceptions;


public class HotelNotFoundException extends RuntimeException{

	public HotelNotFoundException(String message) {
		super(message);
	}
	
	public HotelNotFoundException() {
		super("Hotel Not found by this id !!");
	}
}
