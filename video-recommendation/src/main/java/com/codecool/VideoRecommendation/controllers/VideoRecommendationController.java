package com.codecool.VideoRecommendation.controllers;

import com.codecool.VideoRecommendation.dtos.VideoRecommendationDetailsDTO;
import com.codecool.VideoRecommendation.services.VideoRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class VideoRecommendationController {

    @Autowired
    private VideoRecommendationService videoRecommendationService;

    @PostMapping("/new-recommendation")
    public VideoRecommendationDetailsDTO addNewVideoRecommendation(@RequestBody VideoRecommendationDetailsDTO videoRecommendationDetailsDTO){
        return videoRecommendationService.saveRecommendation(videoRecommendationDetailsDTO);
    }

    @GetMapping(value = "/recommendation/{videoId}")
    public VideoRecommendationDetailsDTO getRecommendationByVideoId(@PathVariable Long videoId){
        return videoRecommendationService.getByVideoId(videoId);
    }
}
