package com.hotel_review.hotel.service.imp;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel_review.hotel.entities.Hotel;
import com.hotel_review.hotel.exceptions.HotelNotFoundException;
import com.hotel_review.hotel.repository.HotelRepository;
import com.hotel_review.hotel.services.HotelService;

@Service
public class HotelServiceimp implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel addHotel(Hotel hotel) {
		String randomUserId=UUID.randomUUID().toString();
		hotel.setHotelId(randomUserId);
		
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel findById(String hotelId) {
		return hotelRepository.findById(hotelId).orElseThrow(()->new HotelNotFoundException("Hotel not found by this id : "+hotelId));
	}

}
