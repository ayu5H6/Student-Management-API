package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

        private  final StudentService service;

        public StudentController(StudentService service){
            this.service=service;
        }

        @GetMapping
        public List<Student> getAllStudents(){
         return    service.getAllStudents();
        }

        @GetMapping("/{id}")
        public Student getStudentsById(@PathVariable int id){
            return service.getStudentById(id);
        }

    @PostMapping
    public String addStudent(@RequestBody Student student) {
        service.addStudent(student);
        return "Student added successfully";
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student student) {
        student.setId(id);
        service.updateStudent(student);
        return "Student updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "Student deleted successfully";
    }
}
