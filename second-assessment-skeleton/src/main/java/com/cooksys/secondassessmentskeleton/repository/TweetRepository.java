package com.cooksys.secondassessmentskeleton.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.secondassessmentskeleton.pojo.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {

}
