package com.Samathdada.service;

import java.util.Set;

import com.Samathdada.models.User;
import com.Samathdada.models.UserRole;

public interface Userservice {
	
	//creating user
	
	public User createuser(User user,Set<UserRole> userRoles) throws Exception;
	
	//get user
	
	public User getUser(String username);
	
	//delete user by id
	
	public void deleteUser(Long userId);

}
