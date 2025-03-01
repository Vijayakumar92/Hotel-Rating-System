package com.hotel_review.user.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotel_review.user.client.HotelService;
import com.hotel_review.user.client.RatingService;
import com.hotel_review.user.dto.HotelDTO;
import com.hotel_review.user.entities.Rating;
import com.hotel_review.user.entities.User;
import com.hotel_review.user.exceptions.UserNotFoundException;
import com.hotel_review.user.repository.UserRepository;
import com.hotel_review.user.service.UserService;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger=LoggerFactory.getLogger(UserServiceImp.class);
	
	@Autowired
	private RatingService ratingService;
	
	@Autowired
	private HotelService hotelService;
	
	public User addUser(User user) {
		String randomUserId=UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}
	
public List<User> getALLUsers() {
		
		List<User> listOfUsers=userRepository.findAll();
		
		List<User> lists=new ArrayList<>();
//		Implement Rating Service call using Rest Template
		for(User user:listOfUsers) {
			String userId=user.getUserId();
			ArrayList<Rating> allRatingsByuserId=restTemplate.getForObject("http://RATING-SERVICE/ratingcontroller/getallbyuserid/"+userId, ArrayList.class);
			user.setRatings(allRatingsByuserId);
			lists.add(user);
		}
		
//		userRepository.saveAll(lists); // no need to save because raingList is transient in UserEntity
		return lists;
	}

//	@Override
//	public User getUserById(String userId) {
//		
//		User user=userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User not found by id : "+userId));
//		
//		// here only users details coming but rating details not comming , List of ratings attribute is there in user entity
//		//we have to make api call to rating service
//		
//		// Use ParameterizedTypeReference to specify the response type as List<Rating>
//		ResponseEntity<List<Rating>> ratingResponse = restTemplate.exchange(
//		        "http://localhost:8084/ratingcontroller/getallbyuserid/"+userId, // URL
//		        HttpMethod.GET,               // HTTP method (GET)
//		        null,                         // Request entity (null for GET request)
//		        new ParameterizedTypeReference<List<Rating>>() {} // Parameterized type for List<Rating>
//		    );
//	    
//	    // Extract the list of Rating objects
//	    List<Rating> ratingsOfUser = ratingResponse.getBody();
//	    
//	logger.info("{} "+ratingsOfUser);
//		
//		for(Rating rating: ratingsOfUser) {
//			String hotelId=rating.getHotelId();
//			HotelDTO hotelDTO=restTemplate.getForObject("http://localhost:8083/hotelcontroller/getbyid/"+hotelId, HotelDTO.class);
//			rating.setHotelDTO(hotelDTO);
////			ratingsOfUser.add(rating); no need to add it will automatically update after setting data
//		}
//		
//		user.setRatings(ratingsOfUser);
//		return user;
//	}
	
	
	
	@Override
	public User getUserById(String userId) {
		User user=userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User not found by id : "+userId));

//		Rating[] ratingArr =restTemplate.getForObject("http://RATING-SERVICE/ratingcontroller/getallbyuserid/"+user.getUserId(), Rating[].class);
		
//		List<Rating> list=Arrays.stream(ratingArr).toList();
		
//		we can do it by feign client
		List<Rating> list=ratingService.getAllRatingsByUserId(userId);
		
		List<Rating> ListOfRatings=list.stream().map(rating->{
			
//			ResponseEntity<HotelDTO> getForHotel=restTemplate.getForEntity("http://HOTEL-SERVICE/hotelcontroller/getbyid/"+rating.getHotelId(), HotelDTO.class);
//			HotelDTO hoteldto=getForHotel.getBody();
			
//			we can do it by feign client also
			HotelDTO hoteldto=hotelService.getbyid(rating.getHotelId());
			rating.setHotelDTO(hoteldto);
			
			return rating;
		}).collect(Collectors.toList());
		
		user.setRatings(ListOfRatings);
		return user;
	}

	public String deleteUserById(String userId) {
		userRepository.deleteById(userId);
		return "User Deleted Successfully";
	} 



}
