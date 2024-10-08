package com.practise.local.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.practise.local.model.ChatMessage;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
	List<ChatMessage> findByChatId(String chatId);
}
