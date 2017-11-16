package com.cooksys.secondassessmentskeleton.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cooksys.secondassessmentskeleton.mapper.ProfileMapper;
import com.cooksys.secondassessmentskeleton.pojo.Profile;
import com.cooksys.secondassessmentskeleton.pojo.User;
import com.cooksys.secondassessmentskeleton.repository.ProfileRepository;
import com.cooksys.secondassessmentskeleton.repository.UserRepository;

@Service
public class ProfileService {
	private ProfileRepository profileRepository;
	private ProfileMapper profileMapper;
	private UserRepository userRepository;
	private UserService userService;

	public ProfileService(ProfileRepository profileRepository, ProfileMapper profileMapper,UserRepository userRepository, UserService userService) {
		super();
		this.profileRepository = profileRepository;
		this.profileMapper = profileMapper;
		this.userRepository = userRepository;
		this.userService = userService;
	}

	@Transactional
	public void saveProfile(Profile profile) {
		profileRepository.save(profile);
	}

}
