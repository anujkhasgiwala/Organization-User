package com.cameraiq.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameraiq.dao.OrganizationRepository;
import com.cameraiq.dao.OrganizationUserRepository;
import com.cameraiq.pojo.Organization;
import com.cameraiq.pojo.OrganizationUser;
import com.cameraiq.dao.UserRepository;
import com.cameraiq.pojo.User;

@Service
@Transactional
public class OrganizationUserService {
	
	@Autowired
	private OrganizationUserRepository ouRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrganizationRepository organizationRepository;
	
	//to create organization user mapping if it does not exist
	public OrganizationUser create(OrganizationUser organizationUser) {
		List<OrganizationUser> ouList = ouRepository.findAll();
		if(ouList.contains(organizationUser)) {
			return organizationUser;
		}
		return ouRepository.save(organizationUser);
	}
	
	public void delete(OrganizationUser organizationUser) {
		ouRepository.delete(organizationUser);
	}
	
	public List<User> getUsers(Long orgID) {
		List<Long> userIds = new ArrayList<Long>();
		Optional<OrganizationUser> ouCollection = ouRepository.findById(orgID);
		List<OrganizationUser> ouList = ouCollection.stream().collect(Collectors.toList());
		for(OrganizationUser ou : ouList) {
			userIds.add(ou.getUserId());
		}
		return getUsersById(userIds);
	}
	
	private List<User> getUsersById(List<Long> userIds) {
		return userRepository.findAllById(userIds);
	}
	
	public List<Organization> getOrganizations(Long userID) {
		List<Long> organizationIds = new ArrayList<Long>();
		Optional<OrganizationUser> ouCollection = ouRepository.findById(userID);
		List<OrganizationUser> ouList = ouCollection.stream().collect(Collectors.toList());
		for(OrganizationUser ou : ouList) {
			organizationIds.add(ou.getUserId());
		}
		return getOrganizationsById(organizationIds);
	}
	
	private List<Organization> getOrganizationsById(List<Long> organizationIds) {
		return organizationRepository.findAllById(organizationIds); 
	}
}