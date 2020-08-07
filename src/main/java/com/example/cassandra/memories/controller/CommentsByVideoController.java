package com.example.cassandra.memories.controller;

import com.example.cassandra.memories.model.CommentsByVideo;
import com.example.cassandra.memories.repository.CommentsByVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentsByVideoController {

    @Autowired
    CommentsByVideoRepository commentsByVideoRepository;

    @GetMapping("/commentsbyvideo")
    public List<CommentsByVideo> getCommentsByVideo()
    {
        return commentsByVideoRepository.findAll();
    }

    @PostMapping("/commentsbyvideo")
    public CommentsByVideo addCommentsByVideo(CommentsByVideo commentsByVideo){
        commentsByVideoRepository.save(commentsByVideo);
        return commentsByVideo;
    }
}
