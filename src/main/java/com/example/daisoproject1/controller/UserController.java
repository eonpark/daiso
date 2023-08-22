package com.example.daisoproject1.controller;


import com.example.daisoproject1.domain.User;
import com.example.daisoproject1.dto.UserSignUpDto;
import com.example.daisoproject1.repository.UserRepository;
import com.example.daisoproject1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/test")
    public String test(){
        return "OK";
    }

    @GetMapping("/add")
    public Integer test(@RequestParam Integer a, @RequestParam Integer b){
        return userService.add2(a, b);
    }

    @Autowired
    UserRepository userRepository;

    @PostMapping("/signup")
    public String signUp(@RequestBody User user){
        return userService.signup(user);
    }
}
