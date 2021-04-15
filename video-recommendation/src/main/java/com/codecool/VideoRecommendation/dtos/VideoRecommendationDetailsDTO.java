package com.codecool.VideoRecommendation.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VideoRecommendationDetailsDTO {
    private String id;
    private String videoId;
    private String recommendation;
}
