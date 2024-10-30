package com.example.demo.dto.request;

import lombok.Getter;

import java.util.Date;
@Getter
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String phone;
    private String email;
    private String username;
    private String password;
    private String type;
}
