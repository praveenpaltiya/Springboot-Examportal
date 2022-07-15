package com.Samathdada.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Samathdada.models.User;

public interface UserRepository extends JpaRepository<User,Long>{
		

		

		public User findByUsername(String username);
}
