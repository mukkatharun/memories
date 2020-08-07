package com.example.cassandra.memories.controller;

import com.example.cassandra.memories.model.Videos;
import com.example.cassandra.memories.repository.VideosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class VideosController {

    @Autowired
    VideosRepository videosRepository;

    @GetMapping("/videos")
    public List<Videos> getVideos(){
        return videosRepository.findAll();
    }

    @PostMapping("/videos")
    public Videos addVideos(Videos videos){
        videosRepository.save(videos);
        return videos;
    }
}
