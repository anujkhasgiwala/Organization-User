package com.cameraiq.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cameraiq.pojo.OrganizationUser;

public interface OrganizationUserRepository extends JpaRepository<OrganizationUser, Long> {

}