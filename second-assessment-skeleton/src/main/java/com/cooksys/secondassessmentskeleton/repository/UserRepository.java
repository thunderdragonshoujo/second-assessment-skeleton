package com.cooksys.secondassessmentskeleton.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.secondassessmentskeleton.pojo.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public List<User> findAll();
 

}
