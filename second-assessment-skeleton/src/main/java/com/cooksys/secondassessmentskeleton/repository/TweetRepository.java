package com.cooksys.secondassessmentskeleton.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.secondassessmentskeleton.pojo.Tweet;
import com.cooksys.secondassessmentskeleton.pojo.User;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {
	public List<Tweet> findById(Integer id);

}
