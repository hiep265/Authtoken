package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_user_has_group")
public class UserGroup extends AbstractEntity<Integer> {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    // Có thể thêm các trường bổ sung nếu cần

    // ... (getters và setters)
}