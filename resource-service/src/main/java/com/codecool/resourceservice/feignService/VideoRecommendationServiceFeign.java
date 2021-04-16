package com.codecool.resourceservice.feignService;

import com.codecool.resourceservice.dtos.VideoRecommendationDetailsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "video-reco-service")
public interface VideoRecommendationServiceFeign {

    @PostMapping("/new-recommendation")
    VideoRecommendationDetailsDTO addNewVideoRecommendation(@RequestBody VideoRecommendationDetailsDTO videoRecommendationDetailsDTO);

    @GetMapping("/recommendation/{videoId}")
    List<VideoRecommendationDetailsDTO> getRecommendationByVideoId(@PathVariable Long videoId);

    }