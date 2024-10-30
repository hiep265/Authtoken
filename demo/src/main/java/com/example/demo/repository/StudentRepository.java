package com.example.demo.repository;

import com.example.demo.entity.Student;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// StudentRepository.java
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    Optional<Student> findByStudentId(String studenId);
}

