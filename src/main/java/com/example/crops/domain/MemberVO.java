package com.example.crops.domain;

import lombok.Data;

@Data
public class MemberVO {
    private String userId;
    private String password;
    private String password_con;
    private String name;
    private String role;
}
