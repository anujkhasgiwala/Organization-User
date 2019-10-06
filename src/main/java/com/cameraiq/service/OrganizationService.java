package com.cameraiq.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameraiq.dao.OrganizationRepository;
import com.cameraiq.pojo.Organization;

@Service
@Transactional
public class OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	//to create organization
	public Organization create(Organization organization) {
		return organizationRepository.save(organization);
	}
}
