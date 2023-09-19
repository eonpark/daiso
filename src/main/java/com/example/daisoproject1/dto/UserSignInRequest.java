package com.example.daisoproject1.dto;

import com.example.daisoproject1.domain.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserSignInRequest {
    private String proId;
    private String password;

}
