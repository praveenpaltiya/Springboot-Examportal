package com.Samathdada.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Samathdada.models.User;
import com.Samathdada.models.UserRole;
import com.Samathdada.repo.RoleRepository;
import com.Samathdada.repo.UserRepository;
import com.Samathdada.service.Userservice;

@Service
public class UserserviceImpl implements Userservice{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
//creating user
	@Override
	public User createuser(User user, Set<UserRole> userRoles) throws Exception {
		// TODO Auto-generated method stub
		
	User local=	this.userRepository.findByUsername(user.getUsername());
	
	if(local!=null) {
		System.out.println("user already is there!..");
		throw new Exception("User already present!! ");
	}
	else {
		//create user
		
		for(UserRole ur:userRoles) {
			roleRepository.save(ur.getRole());
		}
		
		user.getUserRoles().addAll(userRoles);
		
		local=this.userRepository.save(user);
	}
		
		return local;
	}
	
	//getting user by username
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		
		this.userRepository.deleteById(userId);
		
	}

}
