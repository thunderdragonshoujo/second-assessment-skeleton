package com.cooksys.secondassessmentskeleton.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cooksys.secondassessmentskeleton.dto.TweetDto;
import com.cooksys.secondassessmentskeleton.mapper.TweetMapper;
import com.cooksys.secondassessmentskeleton.pojo.Tweet;
import com.cooksys.secondassessmentskeleton.repository.TweetRepository;
import com.cooksys.secondassessmentskeleton.repository.UserRepository;

@Service
public class TweetService {
	private TweetRepository tweetRepository;
	private TweetMapper tweetMapper;
	private UserRepository userRepository;

	public TweetService(TweetRepository tweetRepository, TweetMapper tweetMapper, UserRepository userRepository) {
		super();
		this.tweetRepository = tweetRepository;
		this.tweetMapper = tweetMapper;
		this.userRepository = userRepository;
	}

	public void saveTweet(Tweet tweet) {
		userRepository.save(tweet.getAuthor());
		tweetRepository.save(tweet);

	}

	public List<TweetDto> getAllTweets() {
		return tweetRepository.findAll().stream().map(tweetMapper::toDto).collect(Collectors.toList());
	}

	public List<TweetDto> findById(Integer id) {
		return tweetRepository.findById(id).stream().map(tweetMapper::toDto).collect(Collectors.toList());
	}
}
