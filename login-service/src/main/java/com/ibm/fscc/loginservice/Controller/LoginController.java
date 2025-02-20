package com.ibm.fscc.loginservice.Controller;
//The import statements import various classes and interfaces from different packages, allowing the application to use them.
import com.ibm.fscc.loginservice.Response.LoginResponse;
import com.ibm.fscc.loginservice.services.LoginService;
import com.ibm.fscc.loginservice.shared.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Annotation to define this class as a REST controller for handling HTTP requests in a RESTful way.
@RestController// Use to build restfull APIs and controlled when building webapps with servers.
@RequiredArgsConstructor
@RequestMapping(path="/start")// Used to map web requests to specific handler methods. Such as (Get, Post, Put, Delete) or CRUD.
public class LoginController {//Controller class

	// Environment object automatically injected by Spring to provide access to application properties
	@Autowired
	private Environment env;

    @Autowired//used for automatic dependency injection.
	private LoginService loginService;

    // Save to database
	@PostMapping(path = "/save")//This is the path where the request will be mapped.
	public String saveUserName(@RequestBody LoginDto loginDto) {
		return loginService.addUserName(loginDto);
	}

	@PostMapping(path = "/login")//Change access modifier
	public ResponseEntity<?> loginUserName(@RequestBody LoginDto loginDto) {
		LoginResponse loginResponse = loginService.loginUserName(loginDto);
		return ResponseEntity.ok(loginResponse);
	}

	@GetMapping(path="/status/check")
	public String status() {

		return "Working on port " + env.getProperty("server.port");
	}

}
