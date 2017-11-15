package com.cooksys.secondassessmentskeleton.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cooksys.secondassessmentskeleton.dto.UserDto;
import com.cooksys.secondassessmentskeleton.mapper.UserMapper;
import com.cooksys.secondassessmentskeleton.pojo.Credentials;
import com.cooksys.secondassessmentskeleton.pojo.Profile;
import com.cooksys.secondassessmentskeleton.pojo.User;
import com.cooksys.secondassessmentskeleton.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	private UserMapper userMapper;

	public UserService(UserRepository userRepository, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;

		// Credentials credentials =new Credentials("userclint","password");
		// credentialsRepository.save(credentials);
		// Profile profile = new Profile("clint","mcclure","cm@gmail.com","817");
		// userRepository.save(new User("clint",profile,credentials));

	}

	public List<UserDto> getAllUsers() {
		return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
	}

	@Transactional
	public void saveUser(User user) {
		userRepository.save(user);
	}

	public List<UserDto> findByUsername(String username) {
		return userRepository.findByUsername(username).stream().map(userMapper::toDto).collect(Collectors.toList());
	}

	//public ResponseEntity<?> findByUsername(String name) {
		//return userRepository.findByUsername();
	//}
}
