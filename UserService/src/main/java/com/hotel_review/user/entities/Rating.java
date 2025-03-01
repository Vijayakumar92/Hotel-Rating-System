package com.hotel_review.user.entities;

import com.hotel_review.user.dto.HotelDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
	private String ratingId;
	private String UserId;
	private String hotelId;
	private HotelDTO hotelDTO;
	private int rating;
	private String feedback;
}
