package com.example.daisoproject1.controller;


import com.example.daisoproject1.dto.UserSignInRequest;
import com.example.daisoproject1.dto.UserSignUpDto;
import com.example.daisoproject1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/test")
    public String test() {
        return "OK";
    }

    @GetMapping("/add")
    public Integer test(@RequestParam Integer a, @RequestParam Integer b) {
        return userService.add2(a, b);
    }

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody UserSignUpDto userSignUpDto) {
        return ResponseEntity.ok().body(userService.signup(userSignUpDto));
    }

    @GetMapping("/signIn")
    public ResponseEntity signIn(@RequestBody UserSignInRequest userSignInRequest ) {
        return ResponseEntity.ok().body(userService.signIn(userSignInRequest));
    }

}
