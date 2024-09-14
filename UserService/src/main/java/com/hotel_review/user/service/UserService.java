package com.hotel_review.user.service;

import java.util.List;

import com.hotel_review.user.entities.User;

public interface UserService {
	User addUser(User user) ;
	List<User> getALLUsers();
	User getUserById(String userId);
	String deleteUserById(String userId);

}
