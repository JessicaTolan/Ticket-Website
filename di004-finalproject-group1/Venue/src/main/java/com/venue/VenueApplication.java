package com.venue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.venue")
public class VenueApplication {

	public static void main(String[] args) {
		SpringApplication.run(VenueApplication.class, args);
	}

}
