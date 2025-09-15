package com.example.student.repository;

import com.example.student.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    private RowMapper<Student> studentRowMapper=(rs,rowNum)->{
        Student s=new Student();
        s.setId(rs.getInt("id"));
        s.setName((rs.getString("name")));
        s.setEmail(rs.getString("email"));
        s.setAge(rs.getInt("age"));
        return s;

    };

    //CRUD IMP

    public List<Student> findAll(){
        return jdbcTemplate.query("SELECT * FROM student", studentRowMapper);
    }

    public Student findById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM student WHERE id = ?",studentRowMapper,id);
    }

    public int save(Student student){
        return jdbcTemplate.update("INSERT INTO student (name, email, age) VALUES (?, ?, ?)",
                student.getName(), student.getEmail(),student.getAge());
    }

    public int update(Student student){
        return jdbcTemplate.update(
                "UPDATE student SET name=?, email=?, age=? WHERE id=?",
                student.getName(),student.getEmail(),student.getAge(),student.getId()
        );
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM student WHERE id = ?", id);
    }
}
