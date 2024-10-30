package com.example.demo.service;

import com.example.demo.dto.request.SignInRequest;
import com.example.demo.dto.response.TokenResponse;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.JwtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtServiceImpl   jwtService;
  @Autowired
    private AuthenticationManager authenticationManager;
    public TokenResponse authenticate(SignInRequest request){
        try {
            var user=userRepository.findByUsername(request.getUsername()).orElseThrow(()->new UsernameNotFoundException("username or password is incorrect"));
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
            String accessToken=jwtService.generateToken(user);
            return  TokenResponse.builder()
                    .accessToken(accessToken)
                    .refreshToken("refresh_token")
                    .userId(user.getId())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
