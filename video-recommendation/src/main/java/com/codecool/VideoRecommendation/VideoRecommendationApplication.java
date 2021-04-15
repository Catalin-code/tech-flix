package com.codecool.VideoRecommendation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class VideoRecommendationApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoRecommendationApplication.class, args);
	}

}
