package com.ibm.fscc.loginservice.services;

import com.ibm.fscc.loginservice.data.UserEntity;
import com.ibm.fscc.loginservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(String email, String password) {
        password = passwordEncoder.encode(password);
        UserEntity user = new UserEntity(email, password);
        userRepository.save(user);
        return "User with email: " + email + " has been registered";
    }

    public String authenticate(String email, String password) {
        return "User " + email + " authenticated with password " + password;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user  = userRepository.findByEmail(username);

        if (user.isPresent()){
            return user.get();
        }
        else{
            throw new UsernameNotFoundException(username + " doesn't exist!");
        }
    }


}
