package com.cooksys.secondassessmentskeleton.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.secondassessmentskeleton.pojo.User;
import com.cooksys.secondassessmentskeleton.repository.UserRepository;

@RestController
@RequestMapping
public class UserValidateController {
	private UserRepository userRepository;

	public UserValidateController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("validate/username/exists/@{username}")
	public boolean userNameExist(String username) {
		List<User> result = null;
		result = userRepository.findByUsername(username);
		if (result.size() == 1) {
			return true;
		} else {
			return false;
		}
	}

	@GetMapping("validate/username/available/@{username}")
	public boolean userNameAvailable(String username) {
		List<User> result = null;
		result = userRepository.findByUsername(username);
		if (result.size() == 1) {
			return false;
		} else {
			return true;
		}
	}
}
