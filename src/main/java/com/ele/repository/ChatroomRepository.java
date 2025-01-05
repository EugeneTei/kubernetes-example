package com.ele.repository;

import com.ele.repository.entity.Chatroom;
import com.ele.repository.entity.ChatroomCompositeKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatroomRepository extends CassandraRepository<Chatroom, ChatroomCompositeKey> {
}
