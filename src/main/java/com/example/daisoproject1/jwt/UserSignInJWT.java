package com.example.daisoproject1.jwt;

import com.example.daisoproject1.domain.User;
import com.example.daisoproject1.dto.UserSignInRequest;
import com.example.daisoproject1.repository.UserRepository;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

public class UserSignInJWT {
    private JwtTokenProvider jwtTokenProvider;
    public String createToken(UserSignInRequest userSignInRequest) {
        return jwtTokenProvider.createToken(userSignInRequest.getProId());
    }

}
