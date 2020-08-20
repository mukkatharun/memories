package com.example.cassandra.memories.repository;

import com.example.cassandra.memories.KeysHelper.LatestVideosKey;
import com.example.cassandra.memories.model.LatestVideos;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface LatestVideosRepository extends CassandraRepository<LatestVideos, LatestVideosKey> {

    public List<LatestVideos> findByLatestVideosKey_Yyyymmdd(String yyyymmdd);
}
