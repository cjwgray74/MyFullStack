package com.ibm.fscc.kafka.controller;


import com.ibm.fscc.kafka.broker.UserMessage;
import com.ibm.fscc.kafka.model.UserEntity;
import com.ibm.fscc.kafka.command.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/user")
public class KafkaController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private Environment env;


    @GetMapping(path = "/status/check")
    public String status() {
        return "Working on port " + env.getProperty("server.port") + "!";
    }

    @PostMapping(path = "/register")
    public ResponseEntity<String> register(@RequestBody UserMessage userMessage) {
        try {
            employeeService.addToTopic(userMessage);
            return new ResponseEntity<>("User successfully registered.", HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>("User registration failed.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/email")
    public UserEntity findByEmail(@RequestParam String email) {
        return employeeService.getUser(email);
    }

    @GetMapping(path = "/all")
    public List<UserEntity> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping(path = "/status")
    public List<UserEntity> findAllByStatus(@RequestParam String status) {
        return employeeService.getAllByStatus(status);
    }


}
