package com.cooksys.secondassessmentskeleton.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cooksys.secondassessmentskeleton.dto.UserDto;
import com.cooksys.secondassessmentskeleton.exceptions.UserException;
import com.cooksys.secondassessmentskeleton.exceptions.UserNotFoundException;
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

	public UserService(UserRepository userRepository, UserMapper userMapper, ProfileRepository profileRepository,
			CredentialsRepository credentialsRepository) {
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
		User user1 = new User("clint", profile, credentials);
		user1.setActive(true);
		userRepository.save(user1);
		credentials = new Credentials("nate", "minn");
		credentialsRepository.save(credentials);
		profile = new Profile("nate", "lubitz", "nl@gmail.com", "8175551212");
		profileRepository.save(profile);
		User user2 = new User("nate", profile, credentials);
		user2.setActive(true);
		userRepository.save(user2);
	}

	public List<UserDto> getAllUsers() throws UserException {
		try {
			return userRepository.findAll().stream().filter(u -> u.getActive() == true).map(userMapper::toDto)
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new UserException("ERROR USER EXCEPTION");
		}
	}

	@Transactional
	public void saveUser(User user) throws UserException {
		User tempUser = null;
		try {
		 tempUser = userRepository.findByUsername(user.getUsername()).get(0);
		}catch(java.lang.IndexOutOfBoundsException e) {
			System.out.println("no user exsting found");
		}
		if(tempUser != null && user.getActive()==false) {
			tempUser.setActive(true);
			userRepository.save(user);
			return;
		}
		if(tempUser != null) {
			throw new UserException("User already exsist");
		}
		try {
			if (user.getUsername().isEmpty()) {
				throw new UserException("ERROR USER EXCEPTION");
			}
			if (user.getProfile()==null) {
				throw new UserException("ERROR USER EXCEPTION");
			}
			userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserException("ERROR USER EXCEPTION");

		}
	}

	public List<UserDto> findByUsername(String username)throws UserNotFoundException {
		List<UserDto> result = null;
		try {
			result = userRepository.findByUsername(username).stream().map(userMapper::toDto).collect(Collectors.toList());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result.size()==0) {
			throw new UserNotFoundException("USER NOT FOUND");
		}
		return result;
	}

	public void updateUserProfile(User user) {
		User userToUpdate = userRepository.findByUsername(user.getUsername()).get(0);
		System.out.println(userToUpdate.toString());
		User inputUser = user;
		Profile profileToUpdate = userToUpdate.getProfile();
		Profile inputProfile = inputUser.getProfile();
		// userToUpdate.setProfile(inputProfile);
		if (inputProfile.getEmail() != null) {
			profileToUpdate.setEmail(inputProfile.getEmail());
		}
		profileRepository.save(profileToUpdate);
		// userRepository.save(userToUpdate);
	}

	public void deleteUser(String username) {
		User userToDelete = userRepository.findByUsername(username).get(0);
		System.out.println("YYYYYYYYYYYLYYYYY" + userToDelete.toString());
		userToDelete.setActive(false);
		userRepository.save(userToDelete);

	}
}
