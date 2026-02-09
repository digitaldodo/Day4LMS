package com.example.day4lms.controller;

import com.example.day4lms.dto.StudentRequestDto;
import com.example.day4lms.dto.StudentResponseDto;
import com.example.day4lms.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/")
    public String l() {
        return "hi there.";
    }

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/add-student")
    public StudentResponseDto addStart(@Valid @RequestBody StudentRequestDto student) {
        return service.addStudent(student);
    }

    // Display Student
    @GetMapping("/students")
    public List<StudentResponseDto> getStudents() {
        return service.getAllStudents();
    }

    // update Student
    @PutMapping("/update/{id}")
    public StudentResponseDto updateStudent(@PathVariable String id, @Valid @RequestBody StudentRequestDto student) {
        return service.updateStudent(id, student);
    }

    // Delete Student
    @DeleteMapping("/delete/{id}")
    public StudentResponseDto deleteStudent(@PathVariable String id) {
        return service.deleteStudent(id);
    }

    // Partial Update Student (PATCH)
    @PatchMapping("/patch/{id}")
    public StudentResponseDto patchStudent(@PathVariable String id, @RequestBody StudentRequestDto student) {
        return service.patchStudent(id, student);
    }
}
