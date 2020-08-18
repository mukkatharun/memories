package com.example.cassandra.memories.controller;

import com.example.cassandra.memories.model.LatestVideos;
import com.example.cassandra.memories.repository.LatestVideosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LatestVideosController {

    @Autowired
    LatestVideosRepository latestVideosRepository;

    @GetMapping("/latestvideos")
    public List<LatestVideos> getLatestVideos(){
        return latestVideosRepository.findAll();
    }

    @PostMapping("/latestVideos")
    public LatestVideos addLatestVideo(@RequestBody LatestVideos latestVideo){
        latestVideosRepository.save(latestVideo);
        return latestVideo;
    }
}
