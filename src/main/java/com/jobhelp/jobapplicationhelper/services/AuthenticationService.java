package com.jobhelp.jobapplicationhelper.services;

import com.jobhelp.jobapplicationhelper.data.UserRepositoryInterface;
import com.jobhelp.jobapplicationhelper.dto.LoginUserDto;
import com.jobhelp.jobapplicationhelper.dto.RegisterUserDto;
import com.jobhelp.jobapplicationhelper.entities.UserEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
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

    public UserEntity login(LoginUserDto loginUser) throws BadCredentialsException {
        UserEntity user = userRepository.findByEmail(loginUser.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Username or password is incorrect"));

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginUser.getEmail(),
                            loginUser.getPassword()
                    )
            );
        }
        catch(AuthenticationException e) {
            throw new BadCredentialsException("Username or password is incorrect");
        }
        return user;
    }
}
