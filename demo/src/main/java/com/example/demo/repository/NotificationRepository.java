package com.example.demo.repository;

import com.example.demo.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// NotificationRepository.java
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
