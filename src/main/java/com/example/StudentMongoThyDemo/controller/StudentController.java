package com.example.StudentMongoThyDemo.controller;

import com.example.StudentMongoThyDemo.model.Student;
import com.example.StudentMongoThyDemo.service.StudentService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Optional<Student> studentOp = studentService.getStudentById(id);
        Student student = studentOp.get();
      if (student != null) {
           model.addAttribute("student", student);
            return "edit-student";
      } else {
            return "redirect:/";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable String id, @ModelAttribute Student updatedStudent) {
        System.out.println("sua hoc sinh 222222222:");
        studentService.updateStudent(id, updatedStudent);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        System.out.println("xoa id: " + id);
        studentService.deleteStudent(id);
        return "redirect:/";
    }
    @GetMapping("/search")
    public String searchStudents(@RequestParam("firstName") String firstName, Model model) {
        List<Student> searchResults = studentService.searchStudentsByFirstName(firstName);
        model.addAttribute("students", searchResults);
        return "student-list";
    }
}



