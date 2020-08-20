package com.example.cassandra.memories.controller;

import com.example.cassandra.memories.model.CommentsByVideo;
import com.example.cassandra.memories.model.LatestVideos;
import com.example.cassandra.memories.repository.LatestVideosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LatestVideosController {

    @Autowired
    LatestVideosRepository latestVideosRepository;

    @GetMapping("/latestvideos")
    public ResponseEntity<List<LatestVideos>> getLatestVideos()
    {
        Timestamp added_date = new Timestamp(System.currentTimeMillis());
        List<LatestVideos> latestVideos = latestVideosRepository.
                findByLatestVideosKey_Yyyymmdd(new SimpleDateFormat("yyyyMMdd").format(added_date));

        return Optional.ofNullable((latestVideos))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse((ResponseEntity.noContent().build()));
    }
}
