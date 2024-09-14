package com.hotel_review.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel_review.hotel.entities.Hotel;
import com.hotel_review.hotel.service.imp.HotelServiceimp;

@RestController
@RequestMapping("/hotelcontroller")
public class HotelController {

	@Autowired
	private HotelServiceimp hotelServiceimp;
	
	@PostMapping("/addhotel")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
		
		return new ResponseEntity<Hotel>(hotelServiceimp.addHotel(hotel),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getallhotels")
	public ResponseEntity<List<Hotel>> getAllHotels(){
		
		return ResponseEntity.status(HttpStatus.OK).body(hotelServiceimp.getAllHotel());
	}
	
	@GetMapping("/getbyid/{hotelId}")
	public ResponseEntity<Hotel> findByHotelId(@PathVariable("hotelId") String hotelId){
		Hotel obj=hotelServiceimp.findById(hotelId);
//		return ResponseEntity.ok(hotelServiceimp.findById(hotelId));
		return ResponseEntity.status(HttpStatus.OK).body(obj);
		
	}
}
