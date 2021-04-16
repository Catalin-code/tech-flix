package com.codecool.videoservice.controllers;

import com.codecool.videoservice.dtos.VideoDTO;
import com.codecool.videoservice.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VideoController {

    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/videos")
    public List<VideoDTO> getAllVideos(){
        return videoService.getAllVideos();
    }

    @PostMapping("/new-video")
    public void addNewVideo(@RequestBody VideoDTO newVideo){
        videoService.addNewVideo(newVideo);
    }

    @GetMapping("/video/{videoId}")
    public VideoDTO getVideoById(@PathVariable Long videoId){
        return videoService.getVideoById(videoId);
    }
}
