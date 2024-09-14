package com.hotel_review.hotel.services;

import java.util.List;

import com.hotel_review.hotel.entities.Hotel;

public interface HotelService {

	Hotel addHotel(Hotel hotel);

	List<Hotel> getAllHotel();

	Hotel findById(String hotelId);
}
