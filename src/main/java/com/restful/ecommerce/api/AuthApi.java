package com.restful.ecommerce.api;

import com.restful.ecommerce.security.TokenManager;
import com.restful.ecommerce.security.model.AuthRequest;
import com.restful.ecommerce.security.model.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthApi {

    private final TokenManager tokenManager;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;


    @PostMapping
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest){

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())
            );

        }catch (BadCredentialsException exception){
            throw exception;
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        return ResponseEntity.ok(
                new AuthResponse(
                        tokenManager.generateToken(userDetails)
                )
        );
    }
}
