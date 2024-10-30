package com.example.demo.repository;

import com.example.demo.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// SettingRepository.java
@Repository
public interface SettingRepository extends JpaRepository<Setting, Long> {
}
