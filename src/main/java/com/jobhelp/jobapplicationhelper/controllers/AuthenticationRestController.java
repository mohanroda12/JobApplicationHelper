package com.jobhelp.jobapplicationhelper.controllers;

import com.jobhelp.jobapplicationhelper.Responses.LoginResponse;
import com.jobhelp.jobapplicationhelper.dto.LoginUserDto;
import com.jobhelp.jobapplicationhelper.dto.RegisterUserDto;
import com.jobhelp.jobapplicationhelper.entities.UserEntity;
import com.jobhelp.jobapplicationhelper.services.AuthenticationService;
import com.jobhelp.jobapplicationhelper.services.JwtService;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
    public ResponseEntity<?> register(@Valid @RequestBody RegisterUserDto registerUserDto, BindingResult result) {
        if(result.hasErrors()) {
            return error(HttpStatus.BAD_REQUEST, validationMessage(result));
        }
        try {
            UserEntity registeredUser = authenticationService.signup(registerUserDto);
            return ResponseEntity.ok(registeredUser);
        }
        catch(DataIntegrityViolationException e) {
            return error(HttpStatus.CONFLICT, "Email already in use");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@Valid @RequestBody LoginUserDto loginUserDto) {
        UserEntity authenticatedUser;
        try {
            authenticatedUser = authenticationService.login(loginUserDto);
        }
        catch(BadCredentialsException e) {
            return error(HttpStatus.UNAUTHORIZED, e.getMessage());
        }

        String jwtToken = jwtService.generateAccessToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getJwtExpiration());
        return ResponseEntity.ok(loginResponse);
    }

    private ResponseEntity<Map<String, String>> error(HttpStatus httpStatus, String message) {
        return ResponseEntity.status(httpStatus).body(Map.of("error", message));
    }

    private String validationMessage(BindingResult result) {
        // Get the first error
        FieldError error = result.getFieldError();
        if(error != null) {
            return error.getDefaultMessage();
        }
        return null;
    }
}
