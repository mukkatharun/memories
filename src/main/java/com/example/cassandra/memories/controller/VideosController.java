package com.example.cassandra.memories.controller;

import com.example.cassandra.memories.model.Videos;
import com.example.cassandra.memories.repository.VideosRepository;
import com.example.cassandra.memories.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/")
public class VideosController {

    @Autowired
    VideosRepository videosRepository;

    @Autowired
    private VideoService videoService;

    @GetMapping("/videos")
    public ResponseEntity<List<Videos>> getVideos(){
        List<Videos> videos = videosRepository.findAll();
        return Optional.ofNullable(videos)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("/videos/{id}")
    public ResponseEntity<Optional<Videos>> getVideo(@PathVariable("id")UUID videoid){
        Optional<Videos> videos = videosRepository.findById(videoid);
        return Optional.ofNullable(videos)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping("/videos")
    public ResponseEntity<Videos> addVideos(@RequestBody Videos video){
        Videos newVideo = videoService.addVideo(video);

        return Optional.ofNullable(newVideo)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(ResponseEntity.noContent().build());
    }

    @PutMapping("/videos")
    public ResponseEntity<Videos> updateVideos(@RequestBody Videos video){
        Videos newVideo = videoService.updatevideo(video);

        return Optional.ofNullable(newVideo)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(ResponseEntity.noContent().build());
    }

    @DeleteMapping("/videos")
    public boolean deleteVideo(@RequestBody Videos video)
    {
        try{
            videoService.deleteVideo(video);
        }
        catch (Exception ex){
            return false;
        }
        return true;
    }
}
