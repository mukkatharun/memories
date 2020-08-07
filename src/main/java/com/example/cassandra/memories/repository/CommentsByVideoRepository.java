package com.example.cassandra.memories.repository;

import com.example.cassandra.memories.KeysHelper.CommentsByVideoKey;
import com.example.cassandra.memories.model.CommentsByVideo;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface CommentsByVideoRepository extends CassandraRepository<CommentsByVideo, CommentsByVideoKey> {
}
