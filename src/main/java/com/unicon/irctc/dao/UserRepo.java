package com.unicon.irctc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unicon.irctc.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	public User findByUserName(String userName);

	@Query(value = "select * from user u where u.user_id = :userId", nativeQuery = true)
	public User getUsers(int userId);
}
