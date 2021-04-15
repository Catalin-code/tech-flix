package com.codecool.VideoRecommendation.VideoRecommendation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class VideoRecommendationController {

    private final VideoRecommendationService videoRecommendationService;

    @Autowired
    public VideoRecommendationController(VideoRecommendationService videoRecommendationService){this.videoRecommendationService = videoRecommendationService;}


    @GetMapping("recommedations")
    public List<VideoRecommendation> getAllVideosRecommendations(){
        return videoRecommendationService.getAllVideosRecommendations();
    }

    @GetMapping("recommendation/videoId={videoId}")
    public List<VideoRecommendation> getVideoRecommendationById(@PathVariable("videoId")String videoId){
        return videoRecommendationService.getVideoRecommendationById(videoId);
    }

    @PostMapping("new-recommendation")
    public void addNewVideoRecommendation(@RequestBody VideoRecommendation newVideoRecommendation){
        videoRecommendationService.addNewVideoRecommendation(newVideoRecommendation);
    }
}
