package com.tan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tan.entity.User;
import com.tan.service.UserServiceInterface;

@RestController
public class UserRest {
	@Autowired 
	private UserServiceInterface service;
	
	@PostMapping(value ="/save",consumes = "application/json")
	public String save(@RequestBody User u) {
		service.save(u);
		return "User Saved";
	}
	
	@GetMapping(value = "/list", consumes = "application/json")
	public List<User> list(){
		return service.list();
	}
	
	@GetMapping(value = "/fetch/{uid}",produces = "application/json")
	public User fetch(@PathVariable int uid) {
		return service.fetch(uid);
	}
	
	@DeleteMapping(value = "/delete/{uid}")
	public void delete(@PathVariable int uid) {
		service.remove(uid);
	}
	
}
