package com.example.daisoproject1.service;

import com.example.daisoproject1.domain.User;
import com.example.daisoproject1.dto.UserResponse;
import com.example.daisoproject1.dto.UserSignInRequest;
import com.example.daisoproject1.dto.UserSignUpDto;
import com.example.daisoproject1.jwt.JwtTokenProvider;
import com.example.daisoproject1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository user;

    public Integer add2(int a, int b){
        return a + b;
    }

    private final UserRepository userRepository;
    private JwtTokenProvider jwtTokenProvider;
    @Value("${security.jwt.token.secret-key}")
    String secretKey;

    @Value("${security.jwt.token.expire-length}")
    long limit;

    public UserResponse signup(UserSignUpDto userDto) {
        String proId = userDto.getProId();

        // is_duplicated
        if (userRepository.findUserByProId(proId).equals(null)) {
            throw new RuntimeException();

        }

        User user = UserSignUpDto.toEntity(userDto);
        userRepository.save(user);

        return UserResponse.fromEntity(user);
    }

    public String signIn(UserSignInRequest userSignInRequest) {
        String proId = userSignInRequest.getProId();
        User user = userRepository.findUserByProId(proId).get();
        JwtTokenProvider jwtTokenProvider1 = new JwtTokenProvider(this.secretKey,limit);
        if(user.getPassword().equals(userSignInRequest.getPassword())){
            return jwtTokenProvider1.createToken(proId);
        }
        else{
            throw new RuntimeException();
        }
    }
}
