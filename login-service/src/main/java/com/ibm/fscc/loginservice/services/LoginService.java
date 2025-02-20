package com.ibm.fscc.loginservice.services;

import com.ibm.fscc.loginservice.Response.LoginResponse;
import com.ibm.fscc.loginservice.shared.LoginDto;

public interface LoginService {

	public LoginDto getLogin(String email);

	String addLogin(LoginDto loginDto);
    String addUserName(LoginDto loginDto);
    LoginResponse loginUserName(LoginDto loginDto);
}
