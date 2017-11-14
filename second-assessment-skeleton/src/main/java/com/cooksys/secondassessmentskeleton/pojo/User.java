package com.cooksys.secondassessmentskeleton.pojo;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "usert")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	@OneToOne
	private Profile profile;
	@OneToOne
	private Credentials credentials;
	private Timestamp joined;

	public User() {
		this.joined = Timestamp.from(Instant.now());

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	

	public User(String username,Profile profile,Credentials credentials ) {
		this.username = username;
		this.profile = profile;
		this.credentials = credentials;
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
