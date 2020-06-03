package com.example.adilbek_nurmakov.Coronavirus_track_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CoronavirusTrackAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronavirusTrackAppApplication.class, args);
	}

}
