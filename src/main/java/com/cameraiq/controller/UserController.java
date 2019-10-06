package com.cameraiq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cameraiq.pojo.User;
import com.cameraiq.service.UserService;

@RestController
@EnableAutoConfiguration
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//post method which will create a new User
	@RequestMapping(value = "/api/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public User createUser(@RequestBody User user) {
		if(user != null) {
			return userService.create(user);
		}

		return null;
	}
}
