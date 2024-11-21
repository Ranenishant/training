package com.tan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tan.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	
//	@Query("FROM task WHERE task.tid=:tid")
//	public 
	
}
