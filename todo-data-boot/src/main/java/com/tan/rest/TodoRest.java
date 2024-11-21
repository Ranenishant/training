package com.tan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tan.entity.Todo;
import com.tan.service.TodoServiceInterface;

@RestController
public class TodoRest {
	@Autowired
	private TodoServiceInterface service;
	
	@PostMapping(value = "/savet/{uid}",consumes = "application/json")
	public String save(@RequestBody Todo t, @PathVariable int uid) {
		service.save(t, uid);
		return "Todo Saved!";
	}
	
	@GetMapping(value = "/listt",produces = "application/json")
	public List<Todo> list(){
		return service.list();
	}
	@GetMapping(value = "/fetcht/{tid}")
	public Todo getById(@PathVariable int tid) {
		return service.fetch(tid);
	}
	
	@DeleteMapping(value = "/deletet/{tid}")
	public void delete(@PathVariable int tid) {
		service.remove(tid);
	}
	
	
}
