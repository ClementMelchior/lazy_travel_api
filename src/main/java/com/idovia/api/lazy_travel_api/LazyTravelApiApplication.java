package com.idovia.api.lazy_travel_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class LazyTravelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LazyTravelApiApplication.class, args);
	}

}
