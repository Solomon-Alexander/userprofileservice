package com.demo.userprofile.api.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.demo.userprofile.api.entity.User;

@Service
public interface UserProfileService {
	
	public User getUsersById(Long id);
	
	public User saveUser(User user);
	
	public User updateUser(User user, BindingResult result);

	public void delete(Long id);
	
	public String home();
	
	public String findAllUserNames();

}