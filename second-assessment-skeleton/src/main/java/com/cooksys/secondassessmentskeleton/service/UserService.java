package com.cooksys.secondassessmentskeleton.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cooksys.secondassessmentskeleton.dto.UserDto;
import com.cooksys.secondassessmentskeleton.mapper.UserMapper;
import com.cooksys.secondassessmentskeleton.repository.UserRepository;
@Service
public class UserService {
	private UserRepository userRepository;
	private UserMapper userMapper;

	public UserService(UserRepository userRepository, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	public List<UserDto> getAllUser() {
		return userRepository.getAll().stream().map(userMapper::toDto).collect(Collectors.toList());

	}
}
