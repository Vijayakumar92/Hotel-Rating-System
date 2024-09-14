package com.hotel_review.rating.controller;

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

import com.hotel_review.rating.entities.Rating;
import com.hotel_review.rating.serviceimp.RatingServiceImp;

@RestController
@RequestMapping("/ratingcontroller")
public class RatingController {

	@Autowired
	private RatingServiceImp ratingServiceimp;

	@PostMapping("/createrating")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingServiceimp.createRating(rating));
	}

	@GetMapping("/getallratings")
	public ResponseEntity<List<Rating>> getAllRatings() {

		return ResponseEntity.status(HttpStatus.OK).body(ratingServiceimp.getAllRatings());
	}

	@GetMapping("/getallbyuserid/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable("userId") String userId) {

		return ResponseEntity.status(HttpStatus.OK).body(ratingServiceimp.getAllRatingsByUserId(userId));
	}

	@GetMapping("/getallbyhotelid/{hotelId}")
	public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable("hotelId") String hotelId) {

		return ResponseEntity.status(HttpStatus.OK).body(ratingServiceimp.getAllRatingsByHotelId(hotelId));
	}

}
