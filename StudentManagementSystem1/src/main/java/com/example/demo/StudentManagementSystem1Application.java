package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.entity")
@ComponentScan(basePackages = {"com.example.controller", "com.example.repository"})
@EnableJpaRepositories("com.example.repository")
public class StudentManagementSystem1Application {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystem1Application.class, args);
	}

}
