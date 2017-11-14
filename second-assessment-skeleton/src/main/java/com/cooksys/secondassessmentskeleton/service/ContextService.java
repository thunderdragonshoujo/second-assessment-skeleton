package com.cooksys.secondassessmentskeleton.service;

import org.springframework.stereotype.Service;

import com.cooksys.secondassessmentskeleton.mapper.ContextMapper;
import com.cooksys.secondassessmentskeleton.repository.ContextRepository;

@Service
public class ContextService {
	private ContextRepository contectgRepository;
	private ContextMapper contextMapper;

	public ContextService(ContextRepository contectgRepository, ContextMapper contextMapper) {
		super();
		this.contectgRepository = contectgRepository;
		this.contextMapper = contextMapper;
	}

}
