package com.cooksys.secondassessmentskeleton.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cooksys.secondassessmentskeleton.mapper.ProfileMapper;
import com.cooksys.secondassessmentskeleton.pojo.Profile;
import com.cooksys.secondassessmentskeleton.repository.ProfileRepository;
@Service
public class ProfileService {
	private ProfileRepository profileRepository;
	private ProfileMapper profileMapper;
	
	public ProfileService(ProfileRepository profileRepository, ProfileMapper profileMapper) {
		super();
		this.profileRepository = profileRepository;
		this.profileMapper = profileMapper;
	}
	@Transactional
	public void saveProfile(Profile profile) {
		profileRepository.save(profile);
	}
	
	

}
