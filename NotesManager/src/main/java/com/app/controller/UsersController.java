package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginRequestDto;
import com.app.pojos.User;
import com.app.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public User saveUserDetails(@RequestBody User newEmp){
		System.out.println("in save emp "+newEmp+" id "+newEmp.getId());
		return userService.addUserDetails(newEmp);	
	}
	
	@GetMapping("/{empId}")
	public User getUserDetails(@PathVariable Long empId){
		System.out.println("in get emp details "+empId);
		return userService.fetchUserDetails(empId);
	}
	
	@PostMapping("/signin")
	public User validateUser(@RequestBody LoginRequestDto dto){
		System.out.println("in emp signin "+dto);
		return userService.authenticateUser(dto);
	}
}