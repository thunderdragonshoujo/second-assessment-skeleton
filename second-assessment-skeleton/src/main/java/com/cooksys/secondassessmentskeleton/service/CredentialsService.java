package com.cooksys.secondassessmentskeleton.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cooksys.secondassessmentskeleton.mapper.CredentialsMapper;
import com.cooksys.secondassessmentskeleton.pojo.Credentials;
import com.cooksys.secondassessmentskeleton.pojo.User;
import com.cooksys.secondassessmentskeleton.repository.CredentialsRepository;

@Service
public class CredentialsService {
	private CredentialsRepository credentialsRepository;
	private CredentialsMapper credentialsMapper;

	public CredentialsService(CredentialsRepository credentialsRepository, CredentialsMapper credentialsMapper) {
		super();
		this.credentialsRepository = credentialsRepository;
		this.credentialsMapper = credentialsMapper;
	}

	@Transactional
	public void saveCredentials(Credentials credentials) {
		credentialsRepository.save(credentials);
	}

}
