package com.example.cassandra.memories.repository;

import com.example.cassandra.memories.KeysHelper.LatestVideosKey;
import com.example.cassandra.memories.model.LatestVideos;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface LatestVideosRepository extends CassandraRepository<LatestVideos, LatestVideosKey> {
}
