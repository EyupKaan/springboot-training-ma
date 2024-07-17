package org.eyupkaan;

import org.eyupkaan.controller.StudentController;
import org.eyupkaan.model.Student;
import org.eyupkaan.repository.StudentRepository;
import org.eyupkaan.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
