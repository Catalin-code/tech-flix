package com.codecool.VideoRecommendation.VideoRecommendation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class VideoRecommendationConfig {

    private final VideoRecommendationRepository videoRecommendationRepository;

    @Autowired
    public VideoRecommendationConfig(VideoRecommendationRepository videoRecommendationRepository) {
        this.videoRecommendationRepository = videoRecommendationRepository;
    }

    @Bean
    public CommandLineRunner videoCommandLineRunner(){
        return args -> {
            VideoRecommendation videoRecommendation1 = VideoRecommendation.builder()
                    .recommendation("The easiest to understand java tutorial")
                    .videoId(1L)
                    .build();
            VideoRecommendation videoRecommendation2 = VideoRecommendation.builder()
                    .recommendation("The best java tutorial")
                    .videoId(1L)
                    .build();
            VideoRecommendation videoRecommendation3 = VideoRecommendation.builder()
                    .recommendation("Pretty good Spring Boot tutorial")
                    .videoId(2L)
                    .build();
            VideoRecommendation videoRecommendation4 = VideoRecommendation.builder()
                    .recommendation("Good JPA tutorial")
                    .videoId(3L)
                    .build();

            videoRecommendationRepository.saveAll(List.of(videoRecommendation1, videoRecommendation2, videoRecommendation3, videoRecommendation4));
        };
    }
}
