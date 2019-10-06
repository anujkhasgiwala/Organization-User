package com.cameraiq.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cameraiq.pojo.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}