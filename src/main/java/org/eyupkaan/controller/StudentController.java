package org.eyupkaan.controller;

import org.eyupkaan.model.Student;
import org.eyupkaan.repository.StudentRepository;
import org.eyupkaan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.IconUIResource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    // IoC
    // DI
    //@Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping("/hello")
    public String hello(){
        return "Hello Student Controller";
    }

    // GET - ALL
    @GetMapping("/students")
    public List<Student> getStudentAll(){
        return studentService.getStudentAll();
    }

    // GET - WHERE ID = ?
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
    @PostMapping("/student")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }
    @PutMapping("/student/{id}")
    public Optional<Student> updateStudent(@PathVariable Long id,
                                  @RequestBody Student currentStudent){

        currentStudent.setId(id);
        return studentService.updateStudent(currentStudent);
    }
    @DeleteMapping("/student")
    public void deleteStudent(Long id){
        studentService.deleteStudent(id);
    }
}
