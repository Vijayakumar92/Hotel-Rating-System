package com.hotel_review.user.config;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {
	@Bean
	@LoadBalanced   // to balance load and we used this because i have used Service name in place of localhost:port number to make it dynamic call in userserviceImp  
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}
}

