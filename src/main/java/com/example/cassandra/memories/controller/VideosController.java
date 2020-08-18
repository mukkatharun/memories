package com.example.cassandra.memories.controller;

import com.example.cassandra.memories.model.Videos;
import com.example.cassandra.memories.repository.VideosRepository;
import com.example.cassandra.memories.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class VideosController {

    @Autowired
    VideosRepository videosRepository;

    @Autowired
    private VideoService videoService;

    @GetMapping("/videos")
    public List<Videos> getVideos(){
        return videosRepository.findAll();
    }

    @PostMapping("/videos")
    public Videos addVideos(@RequestBody Videos videos){
        videoService.addVideo(videos);
        return videos;
    }
}
