package com.cooksys.secondassessmentskeleton.service;

import org.springframework.stereotype.Service;

import com.cooksys.secondassessmentskeleton.mapper.HashtagMapper;
import com.cooksys.secondassessmentskeleton.repository.HashtagRepository;

@Service
public class HashtagService {
	private HashtagRepository hashtagRepository;
	private HashtagMapper hashtagMapper;

	public HashtagService(HashtagRepository hashtagRepository, HashtagMapper hashtagMapper) {
		super();
		this.hashtagRepository = hashtagRepository;
		this.hashtagMapper = hashtagMapper;
	}
}
