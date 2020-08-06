package com.example.cassandra.memories.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;
import java.util.UUID;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @PrimaryKey
    private UUID user_id;

    private String email;

    private String fname;

    private String lname;

    private Timestamp user_joined;
}
