package com.example.demo.repository;

import com.example.demo.entity.ScheduleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ScheduleItemRepository.java
@Repository
public interface ScheduleItemRepository extends JpaRepository<ScheduleItem, Long> {
}
