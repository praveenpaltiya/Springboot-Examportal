package com.Samathdada.controller;

import java.security.Principal;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Samathdada.config.JwtUtil;
import com.Samathdada.models.JwtRequest;
import com.Samathdada.models.JwtResponse;
import com.Samathdada.models.User;
import com.Samathdada.service.impl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	


	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private JwtUtil jwtutil;
	
	//generate token
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		try {
			
			authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
			
			
			
		}catch(AccountNotFoundException e) {
			
		   throw new Exception("user not found");
		}
		
		UserDetails userDetails=this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		String Token=this.jwtutil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(Token));
	}
	
	private void authenticate(String username,String password) throws Exception {
		
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
			
		}catch(DisabledException e) {
			throw new Exception("User Disabled"+e.getMessage());
			
		}catch(BadCredentialsException e) {
			
			throw new Exception("Invalid credentials"+e.getMessage());
			
		}
	
	}
	
	//return the details of current user
	
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		 return ((User)this.userDetailsServiceImpl.loadUserByUsername(principal.getName()));
		
	}

}
