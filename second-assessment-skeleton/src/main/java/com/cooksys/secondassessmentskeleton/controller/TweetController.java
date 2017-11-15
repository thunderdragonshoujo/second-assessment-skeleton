package com.cooksys.secondassessmentskeleton.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.secondassessmentskeleton.pojo.Tweet;
import com.cooksys.secondassessmentskeleton.service.TweetService;

@RestController
@RequestMapping("tweet")
public class TweetController {
	private TweetService tweetService;

	public TweetController(TweetService tweetService) {
		super();
		this.tweetService = tweetService;
	}

	@PostMapping
	public void postTweet(@RequestBody Tweet tweet) {

		tweetService.saveTweet(tweet);

	}

}
