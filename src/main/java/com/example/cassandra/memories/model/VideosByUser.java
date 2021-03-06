package com.example.cassandra.memories.model;

import com.example.cassandra.memories.KeysHelper.VideosByUserKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("videos_by_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideosByUser {

    @PrimaryKey
    private VideosByUserKey videosByUserKey;

    private String name;
}
