package com.cooksys.secondassessmentskeleton.pojo;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Required;

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
	private Boolean active;

	public User() {
		this.joined = Timestamp.from(Instant.now());
		System.out.println("user default ctor");
		this.setActive(true);

	}

	public User(String username, Profile profile, Credentials credentials) {
		System.out.println("user  ctor");
		this.username = username;
		this.profile = profile;
		this.credentials = credentials;
		this.joined = Timestamp.from(Instant.now());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	public String getUsername() {
		return username;
	}

	@Required
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", profile=" + profile + ", credentials=" + credentials
				+ ", joined=" + joined + ", active=" + active + "]";
	}

}
