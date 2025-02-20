package com.ibm.fscc.kafka.controller;

import com.ibm.fscc.kafka.request.UserRequest;
import com.ibm.fscc.kafka.response.UserResponse;
import com.ibm.fscc.kafka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/user")
public class KafkaController {

    @Autowired
    private UserService service;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {

        var id = service.saveUser(request);

        var response = new UserResponse((String) id);//String may not be needed

        return ResponseEntity.ok().body(response);
    }




}
