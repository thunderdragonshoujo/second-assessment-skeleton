package com.cooksys.secondassessmentskeleton.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.secondassessmentskeleton.pojo.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
