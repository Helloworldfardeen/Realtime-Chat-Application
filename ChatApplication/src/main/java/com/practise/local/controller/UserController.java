package com.practise.local.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practise.local.model.User;
import com.practise.local.service.UserService;

import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

	private final UserService userService;

	@MessageMapping("/user.addUser")
	@SendTo("/user/public")
	public User addUser(@Payload User user) {
		userService.saveUser(user);
		return user;
	}

	@MessageMapping("/user.disconnectUser")
	@SendTo("/user/public")
	public User disconnectUser(@Payload User user) {
		userService.disconnect(user);
		return user;
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> findConnectedUsers() {
		return ResponseEntity.ok(userService.findConnectedUsers());
	}
}
