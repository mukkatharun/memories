package com.example.cassandra.memories.controller;

import com.example.cassandra.memories.KeysHelper.CommentsByVideoKey;
import com.example.cassandra.memories.model.CommentsByVideo;
import com.example.cassandra.memories.repository.CommentsByVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public CommentsByVideo addCommentsByVideo(@RequestBody CommentsByVideo commentsByVideo){
        commentsByVideoRepository.save(commentsByVideo);
        return commentsByVideo;
    }

    @PutMapping("/commentsbyvideo")
    public CommentsByVideo updateCommentsByVideo(@RequestBody CommentsByVideo commentsByVideo){
        commentsByVideoRepository.save(commentsByVideo);
        return commentsByVideo;
    }

    @DeleteMapping("/commentsbyvideo")
    public boolean deleteCommentsByVideo(@RequestBody CommentsByVideoKey commentsByVideoKey){
        commentsByVideoRepository.deleteById(commentsByVideoKey);
        return true;
    }
}
