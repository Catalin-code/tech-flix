package com.codecool.resourceservice.dtos;

public class VideoRecommendationDetailsDTO {
    private String id;
    private String videoId;
    private String recommendation;

    public VideoRecommendationDetailsDTO(String id, String videoId, String recommendation) {
        this.id = id;
        this.videoId = videoId;
        this.recommendation = recommendation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
