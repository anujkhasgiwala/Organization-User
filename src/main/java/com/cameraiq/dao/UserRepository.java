package com.cameraiq.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cameraiq.pojo.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
