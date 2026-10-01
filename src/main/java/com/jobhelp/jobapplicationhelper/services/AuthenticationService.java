package com.jobhelp.jobapplicationhelper.services;

import com.jobhelp.jobapplicationhelper.data.UserRepositoryInterface;
import com.jobhelp.jobapplicationhelper.dto.LoginUserDto;
import com.jobhelp.jobapplicationhelper.dto.RegisterUserDto;
import com.jobhelp.jobapplicationhelper.entities.UserEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepositoryInterface userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepositoryInterface userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public UserEntity signup(RegisterUserDto input) {
        UserEntity user = new UserEntity(input.getUsername(), input.getEmail(), passwordEncoder.encode(input.getPassword()));
        return userRepository.save(user);
    }

    public UserEntity login(LoginUserDto loginUser) {
        UserEntity user = userRepository.findByEmail(loginUser.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getEmail(),
                        loginUser.getPassword()
                )
        );
        return user;
    }
}
