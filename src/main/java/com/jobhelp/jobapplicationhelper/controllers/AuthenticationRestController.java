package com.jobhelp.jobapplicationhelper.controllers;

import com.jobhelp.jobapplicationhelper.Responses.LoginResponse;
import com.jobhelp.jobapplicationhelper.dto.LoginUserDto;
import com.jobhelp.jobapplicationhelper.dto.RegisterUserDto;
import com.jobhelp.jobapplicationhelper.entities.UserEntity;
import com.jobhelp.jobapplicationhelper.services.AuthenticationService;
import com.jobhelp.jobapplicationhelper.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/auth")
@RestController
public class AuthenticationRestController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationRestController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserEntity> register(@RequestBody RegisterUserDto registerUserDto) {
        UserEntity registeredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        UserEntity authenticatedUser = authenticationService.login(loginUserDto);
        String jwtToken = jwtService.generateAccessToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getJwtExpiration());
        return ResponseEntity.ok(loginResponse);
    }
}
