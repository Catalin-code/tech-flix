package com.codecool.VideoRecommendation.VideoRecommendation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoRecommendationService {

    private final VideoRecommendationRepository videoRecommendationRepository;

    @Autowired
    public VideoRecommendationService(VideoRecommendationRepository videoRecommendationRepository) {
        this.videoRecommendationRepository = videoRecommendationRepository;
    }

    public List<VideoRecommendation> getAllVideosRecommendations(){
        return videoRecommendationRepository.findAll();
    }

    public void addNewVideoRecommendation(VideoRecommendation newVideoRecommendation){
        videoRecommendationRepository.save(newVideoRecommendation);
    }

    public List<VideoRecommendation> getVideoRecommendationById(String videoId){
        return videoRecommendationRepository.findByVideoId(videoId);
    }
}
