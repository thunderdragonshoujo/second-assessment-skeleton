package com.cooksys.secondassessmentskeleton.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.secondassessmentskeleton.dto.UserDto;
import com.cooksys.secondassessmentskeleton.pojo.User;
import com.cooksys.secondassessmentskeleton.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	@GetMapping
	public List<UserDto> getUserList() {
		return userService.getAllUsers();
	}
	@PostMapping
	public void createUser(@RequestBody User user) {
		userService.saveUser(user);
	}

}
