package com.jobhelp.jobapplicationhelper.services;

import com.jobhelp.jobapplicationhelper.data.UserRepositoryInterface;
import com.jobhelp.jobapplicationhelper.entities.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService implements UserServiceInterface{

    private final UserRepositoryInterface userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepositoryInterface userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
