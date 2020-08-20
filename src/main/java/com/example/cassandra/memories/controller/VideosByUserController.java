package com.example.cassandra.memories.controller;

import com.example.cassandra.memories.KeysHelper.VideosByUserKey;
import com.example.cassandra.memories.model.Users;
import com.example.cassandra.memories.model.Videos;
import com.example.cassandra.memories.model.VideosByUser;
import com.example.cassandra.memories.repository.VideosByUserRepository;
import com.example.cassandra.memories.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class VideosByUserController {

    @Autowired
    VideosByUserRepository videosByUserRepository;

    @Autowired
    VideoService videoService;

    @GetMapping("/videosbyuser/{id}")
    public ResponseEntity<List<VideosByUser>> getVideosByUser(@PathVariable("id") UUID userid)
    {
        List<VideosByUser> videosByUsers = videosByUserRepository.findByVideosByUserKey_Userid(userid);
        return Optional.ofNullable(videosByUsers)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping("/videosbyuser")
    public ResponseEntity<Videos> addVideosByUser(@RequestBody Videos video){
        Videos addVideo = videoService.addVideo(video);
        return Optional.ofNullable(addVideo)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(ResponseEntity.noContent().build());
    }

    @DeleteMapping("/videosbyuser")
    public boolean deleteVideosByUser(@RequestBody Videos video)
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
