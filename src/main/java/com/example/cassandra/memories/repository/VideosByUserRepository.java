package com.example.cassandra.memories.repository;

import com.example.cassandra.memories.KeysHelper.VideosByUserKey;
import com.example.cassandra.memories.model.VideosByUser;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface VideosByUserRepository extends CassandraRepository<VideosByUser, VideosByUserKey> {

    public List<VideosByUser> findByVideosByUserKey_Userid (UUID id);
}
