package com.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ticket")
public class TicketsRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketsRestApiApplication.class, args);
	}

}
