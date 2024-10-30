package com.example.demo.entity;

import jakarta.persistence.*;


import java.util.Set;

@Entity
@Table(name = "tbl_permission")
public class Permission extends AbstractEntity<Integer>{
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "permission")
    private Set<RolePermission> rolePermissions;
}