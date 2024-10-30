package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// StudentService.java
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching students", e);
        }
    }

    public Student getStudentById(String studentId) {
        try {
            return studentRepository.findById(studentId)
                    .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        } catch (ResourceNotFoundException e) {
            throw e; // Ném ngoại lệ nếu không tìm thấy sinh viên
        } catch (Exception e) {
            throw new RuntimeException("Error fetching student by ID", e);
        }
    }

    public Student saveStudent(Student student) {
        try {
            return studentRepository.save(student);
        } catch (Exception e) {
            throw new RuntimeException("Error saving student", e);
        }
    }

    public void deleteStudent(String studentId) {
        try {
            studentRepository.deleteById(studentId);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting student", e);
        }
    }
}

// NotificationService.java, ScheduleItemService.java, SettingService.java
// These would be similar to StudentService, but with their respective entities and repositories