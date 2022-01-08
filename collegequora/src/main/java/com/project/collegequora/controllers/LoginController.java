package com.project.collegequora.controllers;

import com.project.collegequora.Response;
import com.project.collegequora.models.User;
import com.project.collegequora.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LoginController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/register")
	public User signUp(@RequestBody User register) {
		userRepository.save(register);
		return register;
	}

	@PostMapping("/login")
	public Response logIn(@RequestBody User verifyuser) {

		User user = userRepository.findByEmail(verifyuser.getEmail());
		if (user.getPassword().equals(verifyuser.getPassword())) {
			return new Response(200, "success");
		}
		return new Response(500, "register first");
	}
}