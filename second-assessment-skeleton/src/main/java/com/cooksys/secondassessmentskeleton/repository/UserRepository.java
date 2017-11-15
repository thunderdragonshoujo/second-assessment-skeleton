package com.cooksys.secondassessmentskeleton.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.cooksys.secondassessmentskeleton.dto.UserDto;
import com.cooksys.secondassessmentskeleton.pojo.Credentials;
import com.cooksys.secondassessmentskeleton.pojo.Profile;
import com.cooksys.secondassessmentskeleton.pojo.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public List<User> findAll();
	public List<User> findByUsername(String username);


 

}
