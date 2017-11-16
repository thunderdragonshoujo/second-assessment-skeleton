package com.cooksys.secondassessmentskeleton.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.secondassessmentskeleton.dto.TweetDto;
import com.cooksys.secondassessmentskeleton.dto.UserDto;
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
	
	@GetMapping
	public List<TweetDto> getTweetList() {
		return tweetService.getAllTweets();
	}
	
	@GetMapping("/tweets/{id}")
	public Object getUser(@PathVariable("id") Integer id){
		return tweetService.findById(id);
	}

	@PostMapping
	public void postTweet(@RequestBody Tweet tweet) {

		tweetService.saveTweet(tweet);

	}

}
