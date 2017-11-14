package com.cooksys.secondassessmentskeleton.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.secondassessmentskeleton.service.HashtagService;

@RestController
@RequestMapping("hashtag")
public class HashtagController {
	private HashtagService hashtagService;

	public HashtagController(HashtagService hashtagService) {
		super();
		this.hashtagService = hashtagService;
	}

}
