package com.example.day4lms.service;

import com.example.day4lms.dto.StudentRequestDto;
import com.example.day4lms.dto.StudentResponseDto;
import com.example.day4lms.model.StudentModel;
import com.example.day4lms.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class StudentService {
    public List<StudentResponseDto> getAllStudents() {
        return repository.findAll()
                .stream()
                .map(s -> new StudentResponseDto(
                        s.getId(),
                        s.getName(),
                        s.getAge(),
                        s.getEmail()))
                .toList();
    }

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentResponseDto addStudent(StudentRequestDto dto) {
        StudentModel student = new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel savedStudent = repository.save(student);

        return new StudentResponseDto(
                savedStudent.getId(),
                savedStudent.getName(),
                savedStudent.getAge(),
                savedStudent.getEmail());
    }

    // update
    public StudentResponseDto updateStudent(String id, StudentRequestDto dto) {
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Student Found"));
        existingStudent.setName(dto.getName());
        existingStudent.setAge(dto.getAge());
        existingStudent.setEmail(dto.getEmail());

        StudentModel savedStudent = repository.save(existingStudent);
        return new StudentResponseDto(
                savedStudent.getId(),
                savedStudent.getName(),
                savedStudent.getAge(),
                savedStudent.getEmail());
    }

    // Delete
    public StudentResponseDto deleteStudent(String id) {
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Student Found"));
        repository.delete(existingStudent);
        return new StudentResponseDto(
                existingStudent.getId(),
                existingStudent.getName(),
                existingStudent.getAge(),
                existingStudent.getEmail());
    }
}
