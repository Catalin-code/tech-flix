package com.codecool.videoservice.services;

import com.codecool.videoservice.entities.Video;
import com.codecool.videoservice.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> getAllVideos(){
        return videoRepository.findAll();
    }

    public void addNewVideo(Video newVideo){
        videoRepository.save(newVideo);
    }
}