package com.codecool.VideoRecommendation.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "recommendations")
@Data
public class VideoRecommendationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "videoId")
    private Long videoId;

    @Column(name = "recommendation")
    private String recommendation;


}
