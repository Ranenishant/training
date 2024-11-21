package com.tan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tan.entity.User;
import com.tan.repo.UserRepository;

@Service
public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	private UserRepository repo;
	
	@Override
	public void save(User u) {
		repo.save(u);
	}

	@Override
	public User fetch(int uid) {
		return repo.findById(uid).get();
	}

	@Override
	public void remove(int uid) {
		repo.deleteById(uid);
	}

	@Override
	public List<User> list() {
		return repo.findAll();
	}

}
