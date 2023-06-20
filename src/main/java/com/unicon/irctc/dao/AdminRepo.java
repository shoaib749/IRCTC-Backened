package com.unicon.irctc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unicon.irctc.model.Admin;

@Repository
public interface AdminRepo extends CrudRepository<Admin,Integer> {
	public Admin findByUsername(String username);
}
