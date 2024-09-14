package com.hotel_review.hotel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Hotel_Table")
public class Hotel {

	@Id
	private String hotelId;
	private String hotelName;
	private String hotelLocation;
	private String aboutHotel;
}
