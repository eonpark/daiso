package com.example.daisoproject1.service;

import com.example.daisoproject1.domain.User;
import com.example.daisoproject1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    public Integer add2(int a, int b){
        return a + b;
    }

    private final UserRepository userRepository;

    public String signup(User user) {
        String name = user.getName();
        String password= user.getPassword();
        String proId = user.getProId();

        User user1 = new User();
        user1.setName(name);
        user1.setPassword(password);
        user1.setProId(proId);
        if (userRepository.findByName(name) != null) {
            return "failed";
        }
        userRepository.save(user1);
        return "success";

    }

}
