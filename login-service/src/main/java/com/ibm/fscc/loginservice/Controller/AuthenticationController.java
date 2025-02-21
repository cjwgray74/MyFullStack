package com.ibm.fscc.loginservice.Controller;

import com.ibm.fscc.loginservice.security.JwtService;
import com.ibm.fscc.loginservice.Dto.UserDto;
import com.ibm.fscc.loginservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

// Annotation to define this class as a REST controller for handling HTTP requests in a RESTful way.
@RestController// Use to build restfull APIs and controlled when building webapps with servers.
@RequiredArgsConstructor
@RequestMapping(path="/start")// Used to map web requests to specific handler methods. Such as (Get, Post, Put, Delete) or CRUD.
public class AuthenticationController {//Controller class

	@Autowired
	private UserService userService;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;


	@GetMapping(path="/demo")
	public ResponseEntity<String> sayHello() {
		return ResponseEntity.ok("Hello from demo-controller");
	}

	@PostMapping(path="/register")
	public String register (@RequestBody UserDto userDto) {
		return userService.register(userDto.getEmail(), userDto.getPassword());
	}

	@PostMapping(path="/login")
	public String login(@RequestBody UserDto userDto) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(userDto.getEmail());
		}
		else {
			throw new UsernameNotFoundException("Invalid email or password");
		}
	}
}
