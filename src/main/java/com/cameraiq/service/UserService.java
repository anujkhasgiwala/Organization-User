package com.cameraiq.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameraiq.dao.UserRepository;
import com.cameraiq.pojo.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	//to create organization
	public User create(User user) {
		return userRepository.save(user);
	}
}
