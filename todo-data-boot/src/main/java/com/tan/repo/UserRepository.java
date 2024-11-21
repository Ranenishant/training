package com.tan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.tan.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
