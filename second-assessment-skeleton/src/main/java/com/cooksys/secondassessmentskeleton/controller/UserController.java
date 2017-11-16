package com.cooksys.secondassessmentskeleton.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.secondassessmentskeleton.dto.UserDto;
import com.cooksys.secondassessmentskeleton.exceptions.UserException;
import com.cooksys.secondassessmentskeleton.exceptions.UserNotFoundException;
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

	public UserController(UserService userService, ProfileService profileService,
			CredentialsService credentialsService) {
		super();
		this.userService = userService;
		this.profileService = profileService;
		this.credentialsService = credentialsService;
	}

	@GetMapping
	public List<UserDto> getUserList(HttpServletResponse httpResponse) throws UserException {
		List<UserDto> result = null;
		try {
			result = userService.getAllUsers();
		} catch (UserException e) {
			e.printStackTrace();
			httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);	
		}
		return result;
	}

	@GetMapping("/@{username}")
	public Object getUser(@PathVariable("username") String username,HttpServletResponse httpResponse) {
		Object result = null;
		try {
			result = userService.findByUsername(username);
		} catch (UserNotFoundException e) {
			httpResponse.setStatus(400);
			e.printStackTrace();
		}
		return result;
	}

	@PostMapping
	public void createUser(@RequestBody User user,HttpServletResponse httpResponse) {
		try {
		credentialsService.saveCredentials(user.getCredentials());
		profileService.saveProfile(user.getProfile());
		userService.saveUser(user);
		}catch(Exception e){
			httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			e.printStackTrace();
		}
	}

	@PatchMapping("/@{username}")
	public void patchUser(@RequestBody User user, @RequestParam("username") String username) {
		userService.updateUserProfile(user);
	}

	@DeleteMapping("/@{username}")
	public void deleteUser(@PathVariable("username") String username) {
		userService.deleteUser(username);
	}
}
