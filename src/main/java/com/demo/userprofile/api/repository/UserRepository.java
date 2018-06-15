package com.demo.userprofile.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.userprofile.api.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findAll();

}
