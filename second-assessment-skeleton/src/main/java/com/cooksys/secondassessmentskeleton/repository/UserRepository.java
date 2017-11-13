package com.cooksys.secondassessmentskeleton.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cooksys.secondassessmentskeleton.pojo.Users;

@Repository
public class UserRepository {
	private EntityManager entityManager;

	public UserRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public void create(Users users) {
		entityManager.persist(users);
	}

	public List<Users> getAll() {
		return entityManager.createQuery("FROM Users", Users.class).getResultList();
	}

}
