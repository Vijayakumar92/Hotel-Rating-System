package com.hotel_review.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotel_review.user.client.RatingService;
import com.hotel_review.user.entities.Rating;

@SpringBootTest
class UserServiceApplicationTests {
	
	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() {
	}
	
	@Test
	void createRating() {
		
		Rating rating=Rating.builder().rating(10).hotelId("hoteltest").UserId("usertest").feedback("using feign client").build();
		Rating createdRating=ratingService.createRating(rating);
		System.out.println(createdRating);
	}

}
