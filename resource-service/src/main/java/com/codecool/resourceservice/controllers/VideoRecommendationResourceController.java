package com.codecool.resourceservice.controllers;

import com.codecool.resourceservice.dtos.VideoRecommendationDetailsDTO;
import com.codecool.resourceservice.feignService.VideoRecommendationServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VideoRecommendationResourceController {

    @Autowired
    private VideoRecommendationServiceFeign videoRecommendationServiceFeign;

    @PostMapping("/new-recommendation")
    public VideoRecommendationDetailsDTO addNewVideo(@RequestBody VideoRecommendationDetailsDTO inputRecommendation){
        return videoRecommendationServiceFeign.addNewVideoRecommendation(inputRecommendation);
    }

    @GetMapping("/recommendation/{videoId}")
    public List<VideoRecommendationDetailsDTO> getRecommendationByVideoId(@PathVariable Long videoId){
        return videoRecommendationServiceFeign.getRecommendationByVideoId(videoId);
    }
}
