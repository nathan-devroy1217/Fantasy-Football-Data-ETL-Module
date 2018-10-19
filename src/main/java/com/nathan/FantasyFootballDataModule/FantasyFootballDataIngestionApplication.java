package com.nathan.FantasyFootballDataModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.nathan"})
public class FantasyFootballDataIngestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FantasyFootballDataIngestionApplication.class, args);
	}
}
