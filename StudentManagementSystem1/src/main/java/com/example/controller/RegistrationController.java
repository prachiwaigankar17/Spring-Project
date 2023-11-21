package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Controller
public class RegistrationController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "registration";
    }
    @Transactional
    @PostMapping("/registration")
    public String submitRegistrationForm(Student student, Model model) {
       
        studentRepository.save(student);

       
        model.addAttribute("successMessage", "Submitted successfully");

        return "redirect:/registration";
    }
}
