package com.springboot.demo.services;



import com.springboot.demo.dao.UsersRepo;
import com.springboot.demo.model.MessagesResponse;
import com.springboot.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class LoginRegisterService {
	
	 

	@Autowired
	private UsersRepo usersRepo;

	public MessagesResponse handleLogin(String email, String password){
		
		User user = usersRepo.findUsersByEmail(email);
		
		
		if( user == null ){
			MessagesResponse loginResponse= new MessagesResponse("FAILED", "WRONG USERNAME");
			return  loginResponse;
		}
		if( password.equals(user.getPassword())) {
			return new MessagesResponse("SUCCESS", "LOGIN IN");		}
		
		return new MessagesResponse("FAILED", "WRONG PASSWORD");
	}
	

	public MessagesResponse handleRegister(User user) {

		User userCheck = new User();
		userCheck =usersRepo.findUsersByEmail(user.getEmail());
		
		if( userCheck == null ){
			
			usersRepo.save(user);
			MessagesResponse registerResponce= new MessagesResponse("SUCCESS", "User registration complete."
					);
			return  registerResponce;
		}
		return new MessagesResponse("FAILED", "DUPLICATE email");
	}

}
