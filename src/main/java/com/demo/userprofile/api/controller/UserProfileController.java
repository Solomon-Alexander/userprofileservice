package com.demo.userprofile.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.userprofile.api.repository.UserRepository;
import com.demo.userprofile.api.service.impl.WebUserProfileService;

@RestController
@RequestMapping("/api/user/")
@CrossOrigin(origins = "http://localhost:4201", allowedHeaders = "*")
public class UserProfileController {
	
	@Autowired
	WebUserProfileService webUserProfileService;

	@Autowired
	private UserRepository userRepository;
	
    public UserProfileController(WebUserProfileService webUserProfileService) {
        this.webUserProfileService = webUserProfileService;
    }
	
	@Value("${server.port}")
	String port;

	@GetMapping("/greeting")
	public String hello() {
		return "Hello from a service running at port: " + port + "!";
	}
	
	@Autowired
	RestTemplate restTemplate;
 
	@GetMapping("/helloworld")
	public String home() {
		return this.restTemplate.getForObject("http://USERPROFILE-SERVICE/api/user/summary", String.class);
	}
	
	@GetMapping("/summary")
	public ResponseEntity<?> findAllUserNames() {
		return new ResponseEntity<>("This user Profile service is running OK", HttpStatus.OK);
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getUsersById(@PathVariable Long id) {

		return new ResponseEntity<>(userRepository.findOne(id), HttpStatus.OK);
	}

    
}