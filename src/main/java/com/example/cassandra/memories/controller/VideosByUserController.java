package com.example.cassandra.memories.controller;

import com.example.cassandra.memories.model.Users;
import com.example.cassandra.memories.model.Videos;
import com.example.cassandra.memories.model.VideosByUser;
import com.example.cassandra.memories.repository.VideosByUserRepository;
import com.example.cassandra.memories.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VideosByUserController {

    @Autowired
    VideosByUserRepository videosByUserRepository;

    @Autowired
    VideoService videoService;

    @GetMapping("/videosbyuser")
    public List<VideosByUser> getVideosByUser(){
        return videosByUserRepository.findAll();
    }

    @PostMapping("/videosbyuser")
    public VideosByUser addVideosByUser(@RequestBody VideosByUser video){
        videosByUserRepository.save(video);
        return video;
    }

    @DeleteMapping("/videosbyuser")
    public boolean deleteVideosByUser(@RequestBody Videos video)
    {
        return videoService.deleteVideo(video);
    }
}
