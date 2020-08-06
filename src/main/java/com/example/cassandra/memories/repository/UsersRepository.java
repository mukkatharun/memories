package com.example.cassandra.memories.repository;

import com.example.cassandra.memories.model.Users;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface UsersRepository extends CassandraRepository<Users, UUID> {
}
