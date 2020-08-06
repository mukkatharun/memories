package com.example.cassandra.memories.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;
import java.util.UUID;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Videos {

    @PrimaryKey
    private UUID video_id;

    private Timestamp date_added;

    private String description;

    private String location;

    private String name;

    private UUID user_id;
}
