package com.cooksys.secondassessmentskeleton.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.secondassessmentskeleton.service.TweetService;

@RestController
@RequestMapping("tweet")
public class TweetController {
	private TweetService tweetService;

	public TweetController(TweetService tweetService) {
		super();
		this.tweetService = tweetService;
	}

}
