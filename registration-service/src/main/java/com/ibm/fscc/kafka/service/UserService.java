package com.ibm.fscc.kafka.service;

import com.ibm.fscc.kafka.request.UserRequest;

public interface UserService {
    Object saveUser(UserRequest request);
}
