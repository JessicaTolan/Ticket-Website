package com.seat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.seat")
public class SeatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeatApplication.class, args);
	}

}
