package com.tim.service;

import com.tim.dto.SignupRequest;
import com.tim.model.User;
import com.tim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(SignupRequest signupRequest) {
        // To check if the user is already registered
        boolean emailExists = userRepository.findByEmail(signupRequest.getEmail()).isPresent();
        boolean usernameExists = userRepository.findByUsername(signupRequest.getUsername()).isPresent();

        if (emailExists || usernameExists) {
            throw new RuntimeException("User with this email or username already exists");
        }

        // Encode the password before saving
        User user = new User();
        user.setFirstName(signupRequest.getFirstName());
        user.setLastName(signupRequest.getLastName());
        user.setEmail(signupRequest.getEmail());
        user.setUsername(signupRequest.getUsername().toLowerCase());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setProvider("local");
        // Save the user to the repository
        return userRepository.save(user);
    }
}
