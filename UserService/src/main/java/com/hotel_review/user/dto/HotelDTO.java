package com.hotel_review.user.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {
	@Id
	private String hotelId;
	private String hotelName;
	private String hotelLocation;
	private String aboutHotel;
}
