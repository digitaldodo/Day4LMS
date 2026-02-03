package com.example.day4lms.repository;

import com.example.day4lms.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository <StudentModel, String> {


}

