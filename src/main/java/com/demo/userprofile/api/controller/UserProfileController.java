package com.demo.userprofile.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.userprofile.api.entity.User;
import com.demo.userprofile.api.service.UserProfileService;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4201", allowedHeaders = "*")
public class UserProfileController {
	
	@Autowired
	UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }
	
	@Value("${server.port}")
	String port;

	@GetMapping("/greeting")
	public String hello() {
		return "Hello from a service running at port: " + port + "!";
	}
	
	@GetMapping("/helloworld")
	public String home() {
		return userProfileService.home();
	}
	
	@GetMapping("/summary")
	public ResponseEntity<?> findAllUserNames() {
		return new ResponseEntity<>(userProfileService.findAllUserNames(), HttpStatus.OK);
	}
	
	@GetMapping("/user/detail/{id}")
	public ResponseEntity<?> getUsersById(@PathVariable Long id) {
		return new ResponseEntity<>(userProfileService.getUsersById(id), HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> saveUser(@RequestBody User request) {
		return new ResponseEntity<>(userProfileService.saveUser(request), HttpStatus.CREATED);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User request, BindingResult result) {
		User update = userProfileService.updateUser(request,result);
		return new ResponseEntity<>(update, HttpStatus.OK);
	}

	@DeleteMapping("/user/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		userProfileService.delete(id);
	}
    
}