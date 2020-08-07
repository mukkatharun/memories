package com.example.cassandra.memories.model;

import com.example.cassandra.memories.KeysHelper.CommentsByVideoKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("comments_by_video")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsByVideo {

    @PrimaryKey
    private CommentsByVideoKey commentsByVideoKey;

    private String comment;

    private UUID user_id;
}
