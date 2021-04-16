package com.codecool.resourceservice.controllers;

import com.codecool.resourceservice.dtos.VideoDTO;
import com.codecool.resourceservice.feignService.VideoServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VideoResourceController {

    @Autowired
    private VideoServiceFeign videoServiceFeign;

    @PostMapping("/new-video")
    public VideoDTO addNewVideo(@RequestBody VideoDTO inputVideo){
        return videoServiceFeign.addNewVideo(inputVideo);
    }

    @GetMapping("/videos")
    public List<VideoDTO> getAllVideos(){
        return videoServiceFeign.getAllVideos();
    }

    @GetMapping("/video/{videoId}")
    public VideoDTO getVideoById(@PathVariable Long videoId){
        return videoServiceFeign.getVideoById(videoId);
    }
}
