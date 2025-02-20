package com.ibm.fscc.loginservice.services.impl;

import com.ibm.fscc.loginservice.Response.LoginResponse;
import com.ibm.fscc.loginservice.data.LoginEntity;
import com.ibm.fscc.loginservice.repository.LoginRepository;
import com.ibm.fscc.loginservice.services.LoginService;
import com.ibm.fscc.loginservice.shared.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class LoginIMPL implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

   @Override
    public LoginDto getLogin(String email) {
        return null;
    }

    @Override
    public String addLogin(LoginDto loginDto) {
        return "";
    }



    @Override////informs the compiler that the element is meant to override an element declared in a superclass
    public String addUserName(LoginDto loginDto){

        LoginEntity loginEntity = new LoginEntity(
                loginDto.getId(),
                loginDto.getUserName(),
                loginDto.getEmail(),
                loginDto.getPassword()


        );

        loginRepository.save(loginEntity);

        return loginEntity.getUserName();
    }

    @Override//informs the compiler that the element is meant to override an element declared in a superclass
    public LoginResponse loginUserName(LoginDto loginDto) {

       String msg = "";
       LoginEntity loginEntity1 = loginRepository.findByEmail(loginDto.getEmail());
       if (loginEntity1 != null) {
           String password = loginDto.getPassword();
           String encodedPassword = loginEntity1.getPassword();
           Boolean isPwdRight = password.equals(encodedPassword);
           if (isPwdRight) {
               Optional<LoginEntity> loginEntity = loginRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
               if (loginEntity.isPresent()) {
                   return new LoginResponse("Login Success", true);
               }else{
                   return new LoginResponse("Login Failure", false);
               }
           }else{
               return new LoginResponse("password not match", false);
           }
       }else{
           return new LoginResponse("Email not found", false);
       }



    }
}
