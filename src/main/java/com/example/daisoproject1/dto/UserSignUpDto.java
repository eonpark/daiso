package com.example.daisoproject1.dto;

import lombok.Data;

@Data
public class UserSignUpDto {
    private String proId;
    private String password;

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
}
