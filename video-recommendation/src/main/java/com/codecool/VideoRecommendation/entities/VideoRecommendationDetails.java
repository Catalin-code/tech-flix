package com.codecool.VideoRecommendation.entities;

import javax.persistence.*;

@Entity
@Table(name = "recommendations")
public class VideoRecommendationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long videoId;
    private String recommendation;

    public VideoRecommendationDetails(Long id, Long videoId, String recommendation) {
        this.id = id;
        this.videoId = videoId;
        this.recommendation = recommendation;
    }

    public VideoRecommendationDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
