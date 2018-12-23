package com.springboot.demo.controllers;


import java.util.List;



import  com.springboot.demo.dao.UsersRepo;
import  com.springboot.demo.model.MessagesResponse;
import  com.springboot.demo.model.User;
import  com.springboot.demo.services.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UsersController {


	@Autowired
	private UsersRepo usersRepo;

	@Autowired
	private LoginRegisterService loginRegisterService;



	@GetMapping(path = "/getUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(usersRepo.findAll());
	}

	@RequestMapping(value = "/findUser/{email}" )
	public User findByEmail (@PathVariable("email")String email){
		return (User) usersRepo.findUsersByEmail(email);
	}



	@RequestMapping(value="/login" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)//requestparam gia form data.
	public ResponseEntity<MessagesResponse> loginUserSimple(@RequestParam (value ="email") String email,
			@RequestParam (value="password")String password){
		return ResponseEntity.status(HttpStatus.OK).body(loginRegisterService.handleLogin(email, password));
	}


	@RequestMapping(value = "/register" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessagesResponse> registerUser( User user){
		return ResponseEntity.status(HttpStatus.OK).body(loginRegisterService.handleRegister(user)); 
	}


}