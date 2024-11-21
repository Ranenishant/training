package com.tan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tan.entity.Todo;
import com.tan.entity.User;
import com.tan.repo.TodoRepository;

@Service
public class TodoServiceImpl implements TodoServiceInterface {

	@Autowired
	private TodoRepository repo;
	
	@Autowired
	private UserServiceImpl service;
	
	@Override
	public void save(Todo t, int uid) {
		User u = service.fetch(uid);
		t.setUser(u);
		repo.save(t);
	}

	@Override
	public Todo fetch(int tid) {
		return repo.findById(tid).get();
	}

	@Override
	public void remove(int tid) {
		repo.deleteById(tid);
	}

	@Override
	public List<Todo> tastByUser(int uid) {
		return null;
	}

	@Override
	public List<Todo> listByStatus(int tid) {
		return null;
	}

	@Override
	public List<Todo> list() {
		return repo.findAll();
	}

}
