package com.demo.userprofile.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.demo.userprofile.api.controller.UserProfileController;
import com.demo.userprofile.api.service.UserProfileService;
import com.demo.userprofile.api.service.impl.UserProfileServiceImpl;

/**
 * @author Solomon.Alexander
 */
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(useDefaultFilters=false)  // Disable component scanner
public class UserProfileServiceApplication {

	// Case insensitive: could also use: http://accounts-service
    public static final String USERPROFILE_SERVICE_URL
                                        = "http://USERPROFILE-SERVICE";


	public static void main(String[] args) {
		switch(args.length) {
			case 1: System.setProperty("server.port", args[0]);
		}
		SpringApplication.run(UserProfileServiceApplication.class, args);
	}
	
	@LoadBalanced    // Make sure to create the load-balanced template
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public UserProfileService userProfileService() {
        return new UserProfileServiceImpl(USERPROFILE_SERVICE_URL);
    }

    @Bean
    public UserProfileController userProfileController() {
         return new UserProfileController
                       (userProfileService());  // plug in userprofile-service
    }
}
