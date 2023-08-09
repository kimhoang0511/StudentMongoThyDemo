package com.example.StudentMongoThyDemo.repository;


import com.example.StudentMongoThyDemo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findByFirstNameContainingIgnoreCase(String firstName);

}

