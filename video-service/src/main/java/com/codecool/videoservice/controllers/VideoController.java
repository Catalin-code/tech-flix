package com.codecool.videoservice.controllers;

import com.codecool.videoservice.entities.Video;
import com.codecool.videoservice.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class VideoController {

    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/videos")
    public List<Video> getAllVideos(){
        return videoService.getAllVideos();
    }

    @PostMapping("/new-video")
    public void addNewVideo(@RequestBody Video newVideo){
        videoService.addNewVideo(newVideo);
    }
}
