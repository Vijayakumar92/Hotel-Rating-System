package com.hotel_review.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel_review.hotel.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String>{

}
