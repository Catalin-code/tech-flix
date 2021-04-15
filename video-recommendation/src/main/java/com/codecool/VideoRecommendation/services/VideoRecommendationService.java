package com.codecool.VideoRecommendation.services;

import com.codecool.VideoRecommendation.dtos.VideoRecommendationDetailsDTO;
import com.codecool.VideoRecommendation.entities.VideoRecommendationDetails;
import com.codecool.VideoRecommendation.repositories.VideoRecommendationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VideoRecommendationService {
    private final Logger LOGGER = LoggerFactory.getLogger(VideoRecommendationService.class);

    @Autowired
    private final VideoRecommendationRepository videoRecommendationRepository;

    public VideoRecommendationService(VideoRecommendationRepository videoRecommendationRepository) {
        this.videoRecommendationRepository = videoRecommendationRepository;
    }
    @Transactional
    public VideoRecommendationDetailsDTO saveRecommendation(VideoRecommendationDetailsDTO videoRecommendationDetailsDTO) {
        try {
            VideoRecommendationDetails videoRecommendationDetails = new VideoRecommendationDetails();
            videoRecommendationDetails.setVideoId(Long.parseLong(videoRecommendationDetailsDTO.getVideoId()));
            videoRecommendationDetails.setRecommendation(videoRecommendationDetailsDTO.getRecommendation());
            return getVideoRecommendationDTO(videoRecommendationRepository.save(videoRecommendationDetails));
        } catch (Exception e) {
            LOGGER.warn("/****** Exception in VideoRecoService -> saveupdate()" + e);
        }
        return null;
    }

    public VideoRecommendationDetailsDTO getVideoRecommendationDTO(VideoRecommendationDetails videoRecommendationDetails)
    {
        return new VideoRecommendationDetailsDTO(
            videoRecommendationDetails.getId().toString(),
                videoRecommendationDetails.getVideoId().toString(),
                videoRecommendationDetails.getRecommendation()
        );
    }

    public VideoRecommendationDetailsDTO getByVideoId(Long videoId){
        return getVideoRecommendationDTO(videoRecommendationRepository.getOne(videoId));
    }


}
