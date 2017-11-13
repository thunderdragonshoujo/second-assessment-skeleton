package com.cooksys.secondassessmentskeleton.dto;

import java.sql.Timestamp;

import com.cooksys.secondassessmentskeleton.pojo.Profile;

public class UserDto {
	private Long id;
	private String username;
	private Profile profile;
	private Timestamp joined;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Timestamp getJoined() {
		return joined;
	}

	public void setJoined(Timestamp joined) {
		this.joined = joined;
	}

}
