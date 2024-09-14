package com.hotel_review.rating.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel_review.rating.entities.Rating;
import com.hotel_review.rating.repository.RatingRepository;
import com.hotel_review.rating.service.RatingService;

@Service
public class RatingServiceImp implements RatingService{

	@Autowired
	private RatingRepository ratingRepository;
	
	
	@Override
	public Rating createRating(Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getAllRatingsByUserId(String userId) {
		List<Rating> listOfRatings=ratingRepository.findAllByUserId(userId);
		return listOfRatings;
	}

	@Override
	public List<Rating> getAllRatingsByHotelId(String hotelId) {
		List<Rating> listOfRatings=ratingRepository.findAllByHotelId(hotelId);
		return listOfRatings;
	}

	
}
