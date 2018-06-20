package com.demo.userprofile.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestTemplate;

import com.demo.userprofile.api.entity.User;
import com.demo.userprofile.api.repository.UserRepository;
import com.demo.userprofile.api.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired        // NO LONGER auto-created by Spring Cloud (see below)
    @LoadBalanced     // Explicitly request the load-balanced template with Ribbon built-in
    protected RestTemplate restTemplate; 

    protected String serviceUrl;
    
	@Autowired
	private UserRepository userRepository;

    public UserProfileServiceImpl(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ?
               serviceUrl : "http://" + serviceUrl;
    }
    
	public User getUsersById(Long id) {
		return userRepository.findOne(id);
	}
	
	public User saveUser(User request) {
		return userRepository.save(request);
	}
	
	public User updateUser(User user, BindingResult result) {
		return userRepository.saveAndFlush(user);
	}

	public void delete(Long id) {
		userRepository.delete(id);
	}
	
	public String home() {
		return this.restTemplate.getForObject("http://USERPROFILE-SERVICE/summary", String.class);
	}
	
	public String findAllUserNames() {
		return "This user Profile service is running OK";
	}

}