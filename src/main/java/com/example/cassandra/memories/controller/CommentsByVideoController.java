package com.example.cassandra.memories.controller;

import com.example.cassandra.memories.KeysHelper.CommentsByVideoKey;
import com.example.cassandra.memories.model.CommentsByVideo;
import com.example.cassandra.memories.repository.CommentsByVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CommentsByVideoController {

    @Autowired
    CommentsByVideoRepository commentsByVideoRepository;

    @GetMapping("/commentsbyvideo")
    public ResponseEntity<List<CommentsByVideo>> getCommentsByVideo()
    {
        List<CommentsByVideo> comments = commentsByVideoRepository.findAll();
        return Optional.ofNullable(comments)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping("/commentsbyvideo")
    public ResponseEntity<CommentsByVideo> addCommentsByVideo(@RequestBody CommentsByVideo commentsByVideo){

        CommentsByVideo comment = commentsByVideoRepository.save(commentsByVideo);
        return Optional.ofNullable(comment)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(ResponseEntity.noContent().build());
    }

    @PutMapping("/commentsbyvideo")
    public ResponseEntity<CommentsByVideo> updateCommentsByVideo(@RequestBody CommentsByVideo commentsByVideo){
        CommentsByVideo newCommentsByVideo = commentsByVideoRepository.save(commentsByVideo);

        return Optional.ofNullable(newCommentsByVideo)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(ResponseEntity.noContent().build());
    }

    @DeleteMapping("/commentsbyvideo")
    public boolean deleteCommentsByVideo(@RequestBody CommentsByVideoKey commentsByVideoKey){
        try{
            commentsByVideoRepository.deleteById(commentsByVideoKey);
        }
        catch (Exception ex){
            return false;
        }
        return true;
    }
}
