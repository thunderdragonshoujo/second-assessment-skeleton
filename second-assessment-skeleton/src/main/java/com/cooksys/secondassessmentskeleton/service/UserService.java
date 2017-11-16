package com.cooksys.secondassessmentskeleton.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cooksys.secondassessmentskeleton.dto.UserDto;
import com.cooksys.secondassessmentskeleton.mapper.UserMapper;
import com.cooksys.secondassessmentskeleton.pojo.Credentials;
import com.cooksys.secondassessmentskeleton.pojo.Profile;
import com.cooksys.secondassessmentskeleton.pojo.User;
import com.cooksys.secondassessmentskeleton.repository.CredentialsRepository;
import com.cooksys.secondassessmentskeleton.repository.ProfileRepository;
import com.cooksys.secondassessmentskeleton.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	private UserMapper userMapper;
	private ProfileRepository profileRepository;
	private CredentialsRepository credentialsRepository;

	public UserService(UserRepository userRepository, UserMapper userMapper,ProfileRepository profileRepository, CredentialsRepository credentialsRepository) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.profileRepository = profileRepository;
		this.credentialsRepository = credentialsRepository;

		createSomeTestUsers();

	}
	
    public void createSomeTestUsers() {
        Credentials credentials = null;
        Profile profile = null;
        credentials = new Credentials("clint", "tex");
        credentialsRepository.save(credentials);
        profile = new Profile("clint", "mcclure", "cm@gmail.com", "8179993356");
        profileRepository.save(profile);
        userRepository.save(new User("clint", profile, credentials));
        credentials = new Credentials("nate", "minn");
        credentialsRepository.save(credentials);
        profile = new Profile("nate", "lubitz", "nl@gmail.com", "8175551212");
        profileRepository.save(profile);
        userRepository.save(new User("nate", profile, credentials));
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

	public void updateUserProfile(User user) {
		User userToUpdate = userRepository.findByUsername(user.getUsername()).get(0);
		System.out.println(userToUpdate.toString());
		User inputUser = user;
		Profile profileToUpdate = userToUpdate.getProfile();
		Profile inputProfile = inputUser.getProfile();
		//userToUpdate.setProfile(inputProfile);
		if(inputProfile.getEmail() != null) {
		profileToUpdate.setEmail(inputProfile.getEmail());
		}
		profileRepository.save(profileToUpdate);
		//userRepository.save(userToUpdate);
	}
}
