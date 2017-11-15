package com.cooksys.secondassessmentskeleton.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.secondassessmentskeleton.service.ProfileService;

@RestController
@RequestMapping("profile")
public class ProfileController {
	private ProfileService profileService;

	public ProfileController(ProfileService profileService) {
		super();
		this.profileService = profileService;
	}
	
}
