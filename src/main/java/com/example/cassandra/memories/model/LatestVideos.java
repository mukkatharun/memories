package com.example.cassandra.memories.model;

import com.example.cassandra.memories.KeysHelper.LatestVideosKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@Table("latest_videos")
@AllArgsConstructor
@NoArgsConstructor
public class LatestVideos {

    @PrimaryKey
    private LatestVideosKey latestVideosKey;

    private String name;

    private UUID user_id;
}
