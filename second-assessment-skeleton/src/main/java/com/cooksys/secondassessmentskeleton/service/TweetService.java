package com.cooksys.secondassessmentskeleton.service;

import org.springframework.stereotype.Service;

import com.cooksys.secondassessmentskeleton.mapper.TweetMapper;
import com.cooksys.secondassessmentskeleton.repository.TweetRepository;

@Service
public class TweetService {
	private TweetRepository tweetRepository;
	private TweetMapper tweetMapper;

	public TweetService(TweetRepository tweetRepository, TweetMapper tweetMapper) {
		super();
		this.tweetRepository = tweetRepository;
		this.tweetMapper = tweetMapper;
	}

}
