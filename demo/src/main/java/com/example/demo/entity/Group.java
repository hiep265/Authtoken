package com.example.demo.entity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tbl_group")
public class Group extends AbstractEntity<Integer> {
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "group")
    private Set<UserGroup> userGroups;
    // Getters and setters (except for id, createdAt, updatedAt)
}