package com.practise.local.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.practise.local.model.Status;
import com.practise.local.model.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
	public List<User> findAllByStatus(Status status);
}
