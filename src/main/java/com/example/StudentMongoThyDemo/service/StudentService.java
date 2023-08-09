package com.example.StudentMongoThyDemo.service;

import com.example.StudentMongoThyDemo.model.Student;
import com.example.StudentMongoThyDemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public List<Student> searchStudentsByName(String name) {
        return studentRepository.findByFirstNameContainingIgnoreCase(name);
    }

    public Student addStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    public void updateStudent(String id, Student updatedStudent) {
        updatedStudent.setId(id);
        studentRepository.save(updatedStudent);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
    // Existing methods

        public List<Student> searchStudentsByFirstName(String firstName ) {
            return studentRepository.findByFirstNameContainingIgnoreCase(firstName);
        }


}
