package com.hotel_review.rating.service;

import java.util.List;

import com.hotel_review.rating.entities.Rating;

public interface RatingService {

	public Rating createRating(Rating rating);

	public List<Rating> getAllRatings();

	public List<Rating> getAllRatingsByUserId(String userId);

	public List<Rating> getAllRatingsByHotelId(String hotelId);
}
