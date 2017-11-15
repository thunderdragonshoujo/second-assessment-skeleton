package com.cooksys.secondassessmentskeleton.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.secondassessmentskeleton.dto.UserDto;
import com.cooksys.secondassessmentskeleton.pojo.User;
import com.cooksys.secondassessmentskeleton.service.CredentialsService;
import com.cooksys.secondassessmentskeleton.service.ProfileService;
import com.cooksys.secondassessmentskeleton.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	private UserService userService;
	private ProfileService profileService;
	private CredentialsService credentialsService;

	public UserController(UserService userService, ProfileService profileService, CredentialsService credentialsService) {
		super();
		this.userService = userService;
		this.profileService = profileService;
		this.credentialsService = credentialsService;
	}

	@GetMapping
	public List<UserDto> getUserList() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/@{username}")
	public Object getUser(@PathVariable("username") String username){
		return userService.findByUsername(username);
	}

	@PostMapping
	public void createUser(@RequestBody User user) {
		credentialsService.saveCredentials(user.getCredentials());
		profileService.saveProfile(user.getProfile());
		userService.saveUser(user);
		

	}

}
