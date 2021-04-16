package com.codecool.videoservice;

import com.codecool.videoservice.entities.Video;
import com.codecool.videoservice.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class VideoConfig {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoConfig(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Bean
    public CommandLineRunner videoCommandLineRunner(){
        return args -> {
            Video video1 = Video.builder()
                    .name("Java Full Course | Java Tutorial for Beginners")
                    .url("https://www.youtube.com/watch?v=Qgl81fPcLc8")
                    .build();

            Video video2 = Video.builder()
                    .name("Spring Boot Tutorial | Full Course")
                    .url("https://www.youtube.com/watch?v=9SGDpanrc8U")
                    .build();

            Video video3 = Video.builder()
                    .name("Spring Boot Tutorial | Spring Data JPA")
                    .url("https://www.youtube.com/watch?v=8SGI_XS5OPw")
                    .build();

            Video video4 = Video.builder()
                    .name("Spring Security | FULL COURSE")
                    .url("https://www.youtube.com/watch?v=her_7pa0vrg")
                    .build();

            videoRepository.saveAll(List.of(video1, video2, video3, video4));
        };
    }
}


