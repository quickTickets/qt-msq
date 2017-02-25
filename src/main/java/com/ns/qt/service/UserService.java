package com.ns.qt.service;

import java.util.List;

import com.ns.qt.entities.User;

public interface UserService {
	
	void save(User user);
	
	List<User> findAll();
	
	User findOne(long id);
	
	void delete(long id);

}
