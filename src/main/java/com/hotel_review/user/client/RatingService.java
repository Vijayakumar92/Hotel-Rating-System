package com.hotel_review.user.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hotel_review.user.entities.Rating;

@FeignClient(name="RATING-SERVICE",url="http://localhost:8084/ratingcontroller/")
public interface RatingService  {

	@PostMapping("createrating/")
	Rating createRating(@RequestBody Rating rating);
	
	@GetMapping("/getallbyuserid/{userId}")
	List<Rating> getAllRatingsByUserId(@PathVariable("userId") String userId);
}
