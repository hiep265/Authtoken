package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Lombok;

import java.util.Date;

@Entity
@Table(name = "Students")
@Data
public class Student {

    @Id
    @Column(name = "student_id", length = 10)
    private String studentId;

    @Column(name = "full_name", length = 100)
    private String fullName;
    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "place_of_birth", length = 50)
    private String placeOfBirth;

    @Column(name = "id_number", length = 20)
    private String idNumber;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "class", length = 20)
    private String studentClass;

    @Column(name = "department", length = 100)
    private String department;

    // Getters and Setters
}
