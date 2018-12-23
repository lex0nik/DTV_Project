package com.springboot.demo.dao;



import com.springboot.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository 
public interface UsersRepo extends JpaRepository<User, Long>{
	
	User findUsersByEmail(String email);
	User findUserByEmailAndPassword(String email, String password);
	
	
	
	

}
