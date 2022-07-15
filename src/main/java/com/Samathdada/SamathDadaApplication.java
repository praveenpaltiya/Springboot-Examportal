package com.Samathdada;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Samathdada.models.Role;
import com.Samathdada.models.User;
import com.Samathdada.models.UserRole;
import com.Samathdada.service.Userservice;

@SpringBootApplication
public class SamathDadaApplication implements CommandLineRunner{
	
	//Random random=new Random();
	
	@Autowired
	private Userservice userservice;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SamathDadaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		System.out.println("Starting code");
		
		//Random random=new Random(1000);
		//int otp=random.nextInt(999999);
		//System.out.println("OTP    :" + otp);
		
		/*User user=new User();
		user.setFirstName("Roshni");
		user.setLastName("Rathod");
		user.setUsername("RoshniRathod");
		user.setPassword(this.bCryptPasswordEncoder.encode("9494315918"));
		user.setEmail("RoshniRathod@gmail.com");
		user.setProfile("default.png");
		
		Role role1=new Role();
		role1.setRoleId(44L);
		role1.setRolename("Admin");
		
		Set<UserRole> userroleset=new HashSet<>();
		
		UserRole userrole=new UserRole();
		
		userrole.setRole(role1);
		userrole.setUser(user);
		
		userroleset.add(userrole);
		
	User user1=	this.userservice.createuser(user, userroleset);
	
	System.out.println(user1.getUsername());*/
		
		
				
		
	}

}
