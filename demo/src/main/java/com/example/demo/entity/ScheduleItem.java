package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "ScheduleItems")
@Data
public class ScheduleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_item_id")
    private Integer scheduleItemId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "description", length = 200)
    private String description;

    // Getters and Setters
}
