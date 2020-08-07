package com.example.cassandra.memories.repository;

import com.example.cassandra.memories.model.Videos;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface VideosRepository extends CassandraRepository<Videos, UUID> {
}
