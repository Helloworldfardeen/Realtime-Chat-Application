package com.practise.local.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.practise.local.model.ChatRoom;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
	Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
