package com.cooksys.secondassessmentskeleton.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.secondassessmentskeleton.pojo.Credentials;

public interface CredentialsRepository extends JpaRepository<Credentials, Long> {

}
