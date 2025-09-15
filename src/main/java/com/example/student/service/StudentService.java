package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository){
        this.repository=repository;
    }

    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        return repository.findById(id);
    }

    public int addStudent(Student student) {
        return repository.save(student);
    }

    public int updateStudent(Student student) {
        return repository.update(student);
    }

    public int deleteStudent(int id) {
        return repository.delete(id);
    }

}
