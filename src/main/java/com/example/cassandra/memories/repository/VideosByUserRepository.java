package com.example.cassandra.memories.repository;

import com.example.cassandra.memories.KeysHelper.VideosByUserKey;
import com.example.cassandra.memories.model.VideosByUser;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface VideosByUserRepository extends CassandraRepository<VideosByUser, VideosByUserKey> {
}
