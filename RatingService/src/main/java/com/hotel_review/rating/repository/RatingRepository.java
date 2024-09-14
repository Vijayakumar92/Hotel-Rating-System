package com.hotel_review.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hotel_review.rating.entities.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

	@Query("select r from Rating r where r.userId= :userId")
	public List<Rating> findAllByUserId(@Param("userId") String userId);

	@Query("select p from Rating p where p.hotelId= :hotelId")
	public List<Rating> findAllByHotelId(@Param("hotelId") String hotelId);
}
