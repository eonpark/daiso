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

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toEntity() {
            return new User(null,name, proId,password);
    }
}
