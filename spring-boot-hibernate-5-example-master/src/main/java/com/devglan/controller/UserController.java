package com.devglan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devglan.dao.GroupDetailsDAO;
import com.devglan.model.GroupDetails;
import com.devglan.model.UserDetails;
import com.devglan.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupDetailsDAO groupDetailsDAO;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<UserDetails>> userDetails() {
        
		List<UserDetails> userDetails = userService.getUserDetails();
		return new ResponseEntity<List<UserDetails>>(userDetails, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<GroupDetails>> groupDetails() {
        
		List<GroupDetails> userDetails = groupDetailsDAO.getGroupDetails();
		return new ResponseEntity<List<GroupDetails>>(userDetails, HttpStatus.OK);
	}
	

}
