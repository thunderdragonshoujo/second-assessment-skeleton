package com.cooksys.secondassessmentskeleton.service;

import org.springframework.stereotype.Service;

import com.cooksys.secondassessmentskeleton.mapper.TweetMapper;
import com.cooksys.secondassessmentskeleton.pojo.Tweet;
import com.cooksys.secondassessmentskeleton.repository.TweetRepository;
import com.cooksys.secondassessmentskeleton.repository.UserRepository;

@Service
public class TweetService {
	private TweetRepository tweetRepository;
	private TweetMapper tweetMapper;
	private UserRepository userRepository;

	public TweetService(TweetRepository tweetRepository, TweetMapper tweetMapper,UserRepository userRepository) {
		super();
		this.tweetRepository = tweetRepository;
		this.tweetMapper = tweetMapper;
		this.userRepository = userRepository;
	}

	public void saveTweet(Tweet tweet) {
		userRepository.save(tweet.getAuthor());
		tweetRepository.save(tweet);
		
	}

}
