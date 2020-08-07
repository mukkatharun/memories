package com.example.cassandra.memories.controller;

import com.example.cassandra.memories.model.Users;
import com.example.cassandra.memories.model.VideosByUser;
import com.example.cassandra.memories.repository.VideosByUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VideosByUserController {

    @Autowired
    VideosByUserRepository videosByUserRepository;

    @GetMapping("/videosbyuser")
    public List<VideosByUser> getVideosByUser(){
        return videosByUserRepository.findAll();
    }

    @PostMapping("/videosbyuser")
    public VideosByUser addVideosByUser(@RequestBody VideosByUser video){
        videosByUserRepository.save(video);
        return video;
    }
}
