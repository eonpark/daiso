package com.example.daisoproject1.dto;

import com.example.daisoproject1.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserResponse {
    private String name;
    private String proId;


    public UserResponse(String name, String proId){
        this.name = name;
        this.proId = proId;
    }

    public static UserResponse fromEntity(User user) {
        return new UserResponse(user.getName(), user.getProId());
    }

}
