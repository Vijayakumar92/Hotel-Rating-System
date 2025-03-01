package com.hotel_review.user.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel_review.user.entities.User;
import com.hotel_review.user.service.impl.UserServiceImp;

@RestController
@RequestMapping("/usercontroller")
public class UserController {
	
	@Autowired
	private UserServiceImp userServiceimp;
	
	@PostMapping("/adduser")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User obj=userServiceimp.addUser(user);
		return new ResponseEntity<User>(obj,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUsers=userServiceimp.getALLUsers();
		
		return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);
		
	}
	
	@GetMapping("/getuserbyid/{userid}")
	public ResponseEntity<User> getUserById(@PathVariable("userid")String userId){
		User obj=userServiceimp.getUserById(userId);
		return ResponseEntity.status(HttpStatus.OK).body(obj);// this uses ResponseEntity fluent builder APi to create the response
	
	}
	
	@DeleteMapping("/deleteuserbyid/{userid}")
	public ResponseEntity<String> deleteUserById(@PathVariable("userid") String userId){
		String message=userServiceimp.deleteUserById(userId);
		return ResponseEntity.ok(message);  //This returns a ResponseEntity object with an HTTP status of 200 OK and a body that contains the message.

}
}
