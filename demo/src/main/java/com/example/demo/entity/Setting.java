package com.example.demo.entity;

import jakarta.persistence.*;



@Entity
@Table(name = "Settings")
public class Setting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "setting_id")
    private Integer settingId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "dark_mode")
    private Boolean darkMode;

    @Column(name = "language", length = 20)
    private String language;

    @Column(name = "notifications_enabled")
    private Boolean notificationsEnabled;

    // Getters and Setters
}
