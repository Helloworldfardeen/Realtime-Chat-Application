package com.practise.local.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.practise.local.model.Status;
import com.practise.local.model.User;
import com.practise.local.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repository;

	public void saveUser(User user) {
		user.setStatus(Status.ONLINE);
		repository.save(user);
	}

	public void disconnect(User user) {
		var storedUser = repository.findById(user.getNickName()).orElse(null);
		if (storedUser != null) {
			storedUser.setStatus(Status.OFFLINE);
			repository.save(storedUser);
		}
	}

	public List<User> findConnectedUsers() {
		return repository.findAllByStatus(Status.ONLINE);
	}
}
