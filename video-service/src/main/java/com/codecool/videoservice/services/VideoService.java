package com.codecool.videoservice.services;

import com.codecool.videoservice.dtos.VideoDTO;
import com.codecool.videoservice.entities.Video;
import com.codecool.videoservice.repositories.VideoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoService {
    private final Logger LOGGER = LoggerFactory.getLogger(VideoService.class);

    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<VideoDTO> getAllVideos(){
        List<Video> videosList = videoRepository.findAll();
        if(CollectionUtils.isEmpty(videosList)){
            return null;
        }
        return videosList
                .stream()
                .map(this::getVideoDTO)
                .collect(Collectors.toList());
    }

    public VideoDTO addNewVideo(VideoDTO inputVideo){
        try{
            Video newVideo = new Video();
            newVideo.setName(inputVideo.getName());
            newVideo.setUrl(inputVideo.getUrl());
            return getVideoDTO(videoRepository.save(newVideo));
        } catch (Exception e) {
            LOGGER.warn("/******Exception in VideoService -> addNewVideo(): " + e);
        }
        return null;
    }

    public VideoDTO getVideoDTO(Video video){
        return new VideoDTO(
                video.getId().toString(),
                video.getName().toString(),
                video.getUrl().toString()
        );
    }
}
