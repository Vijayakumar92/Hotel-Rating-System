package com.hotel_review.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hotel_review.user.dto.HotelDTO;

@FeignClient(name="HOTEL-SERVICE",url="http://localhost:8083/hotelcontroller/")
public interface HotelService {
	
	@GetMapping("/getbyid/{hotelId}")
	HotelDTO getbyid(@PathVariable("hotelId") String hotelId);

}
