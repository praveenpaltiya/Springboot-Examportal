package com.Samathdada.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/forgot")



public class ForgotPassword {
	//String email="praveen@gmail.com";
	
	@PostMapping("/")
	public String  sendOTP(@RequestParam("email") String email) {
		System.out.println("Email");
		Random random=new Random();
		int otp=random.nextInt(999999);
		System.out.println("OTP   :" + otp);
		return email;
		
		
		
	
		
		
	}

}
