package com.cameraiq.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cameraiq.pojo.Organization;
import com.cameraiq.pojo.OrganizationUser;
import com.cameraiq.pojo.User;
import com.cameraiq.service.OrganizationUserService;

@RestController
public class OrganizationUserController {

	@Autowired
	private OrganizationUserService organizationUserService;
	
	//post method which will add a user to Organization, but this can also be used to add an organization to user.
	//When the mapping of user and organization is sent as a mapping it gets saved.
	@RequestMapping(value = "/api/organizationUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public OrganizationUser createOrganizationUser(@RequestBody OrganizationUser organizationUser) {
		if(organizationUser != null) {
			return organizationUserService.create(organizationUser);
		}

		return null;
	}
	
	//method which will delete a user from Organization, but this can also be used to delete an organization from user.
	@RequestMapping(value = "/api/organizationUser/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteOrganizationUser(@RequestBody OrganizationUser organizationUser) {
		if(organizationUser != null) {
			organizationUserService.create(organizationUser);
		}
	}
	
	// this is used to get list of user for organization
	@RequestMapping(value = "/api/user/{orgID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUsers(@PathParam("orgID") Long orgID) {
		return organizationUserService.getUsers(orgID);
	}
	
	// this is used to get list of organization a user belongs too.
	@RequestMapping(value = "/api/organization/{userID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Organization> getOrganizations(@PathParam("userID") Long userID) {
		return organizationUserService.getOrganizations(userID);
	}
}