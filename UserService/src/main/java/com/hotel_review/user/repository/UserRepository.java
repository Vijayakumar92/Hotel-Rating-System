package com.hotel_review.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel_review.user.entities.User;

@Repository
public interface UserRepository extends  JpaRepository<User, String>{

}
