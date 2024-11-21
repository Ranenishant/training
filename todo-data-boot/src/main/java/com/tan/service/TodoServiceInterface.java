package com.tan.service;

import java.util.List;

import com.tan.entity.Todo;

public interface TodoServiceInterface {
	void save(Todo t, int uid);
	
	Todo fetch(int tid);
	
	void remove(int tid);
	
	List<Todo> list();
	
	List<Todo> tastByUser(int uid);
	
	List<Todo> listByStatus(int tid);
}
