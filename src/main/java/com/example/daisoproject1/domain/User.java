package com.example.daisoproject1.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String proId;
    private String password;



    public User( String name, String proId, String password) {
        this.name = name;
        this.proId = proId;
        this.password = password;
    }
}
