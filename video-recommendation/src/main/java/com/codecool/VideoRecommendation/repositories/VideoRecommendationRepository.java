package com.codecool.VideoRecommendation.repositories;

import com.codecool.VideoRecommendation.entities.VideoRecommendationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRecommendationRepository  extends JpaRepository<VideoRecommendationDetails,Long> {

    List<VideoRecommendationDetails> findByVideoId(Long videoId);

}
