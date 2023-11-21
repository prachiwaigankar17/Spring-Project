package com.example.controller;
import com.example.entity.Instructor;
import com.example.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;

    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Instructor getInstructorById(@PathVariable Long id) {
        return instructorRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @PutMapping("/{id}")
    public Instructor updateInstructor(@PathVariable Long id, @RequestBody Instructor updatedInstructor) {
        updatedInstructor.setId(id);
        return instructorRepository.save(updatedInstructor);
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable Long id) {
        instructorRepository.deleteById(id);
    }
}

