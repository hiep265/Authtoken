package com.example.demo.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "tbl_address")
public class Address extends AbstractEntity<Long> {
    @Column(name = "apartment_number")
    private String apartmentNumber;

    private String floor;
    private String building;

    @Column(name = "street_number")
    private String streetNumber;

    private String street;
    private String city;
    private String country;

    @Column(name = "address_type")
    private String addressType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters and setters (except for id, createdAt, updatedAt)
}