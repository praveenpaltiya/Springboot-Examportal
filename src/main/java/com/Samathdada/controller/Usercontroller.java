package com.Samathdada.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Samathdada.models.Role;
import com.Samathdada.models.User;
import com.Samathdada.models.UserRole;
import com.Samathdada.service.Userservice;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class Usercontroller {
	
	@Autowired
	private Userservice userservice;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//create user
	
	@PostMapping("/")
	public User createuser(@RequestBody User user) throws Exception {
		
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		Set<UserRole> roles=new HashSet<>();
		
		
		
		Role role=new Role();
		role.setRoleId((long) 45);
		role.setRolename("NORMAL");
		
		UserRole userRole=new UserRole();
		
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		
		return this.userservice.createuser(user,roles);
	}
	
	@GetMapping("/{username}")
	
	
	public User getUser(@PathVariable("username") String username) {
		return this.userservice.getUser(username);
		
	}
	
	//delete user by id
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		
		this.userservice.deleteUser(userId);
		
	}
}
