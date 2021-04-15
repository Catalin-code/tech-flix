package com.codecool.resourceservice.feignService;

import com.codecool.resourceservice.dtos.VideoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "video-service")
public interface VideoServiceFeign {

    @PostMapping("/new-video")
    VideoDTO addNewVideo(@RequestBody VideoDTO inputVideo);

    @GetMapping("/videos")
    List<VideoDTO> getAllVideos();
}
