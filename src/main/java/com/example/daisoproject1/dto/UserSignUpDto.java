package com.example.daisoproject1.dto;

import com.example.daisoproject1.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserSignUpDto {
    private String proId;
    private String password;
    private String name;

    public static User toEntity(UserSignUpDto userSignUpDto) {
            return new User(
                    userSignUpDto.name,
                    userSignUpDto.proId,
                    userSignUpDto.password
            );
    }
}
