package com.example.demo.entity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tbl_role")
public class Role extends AbstractEntity<Integer> {
    @Column(nullable = false)
    private String name;


    @OneToMany(mappedBy = "role")
    private Set<RolePermission> rolePermissions;

    // Getters and setters (except for id, createdAt, updatedAt)
}