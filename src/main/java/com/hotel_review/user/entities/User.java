package com.hotel_review.user.entities;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="UserTable")
public class User {
	@Id
	@Column(name="userId")
	private String userId;
	
	@Column(name="userName", length = 20)
	private String userName;
	
	@Column(name="MobileNumber")
	private long userMblNumber;
	
	@Column(name="UserEmailID")
	private String userEmail;
	
	@Column(name="aboutUser",length=30)
	private String aboutUser;
	
	@Transient
	private List<Rating> ratings;

}
