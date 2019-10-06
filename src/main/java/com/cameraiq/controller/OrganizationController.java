package com.cameraiq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cameraiq.pojo.Organization;
import com.cameraiq.service.OrganizationService;

@RestController
@EnableAutoConfiguration
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;
	
	//post method which will create a new Organization
	@RequestMapping(value = "/api/organization", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Organization createOrganization(@RequestBody Organization organization) {
		if(organization != null) {
			return organizationService.create(organization);
		}

		return null;
	}
}
