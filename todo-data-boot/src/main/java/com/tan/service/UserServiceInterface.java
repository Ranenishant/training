package com.tan.service;

import java.util.List;

import com.tan.entity.User;

public interface UserServiceInterface {
	void save(User u);
	
	User fetch(int uid);
	
	void remove(int uid);
	
	List<User> list();
}
