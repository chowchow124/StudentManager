package com.chase.StudentManager.controller;

import com.chase.StudentManager.dao.Student;
import com.chase.StudentManager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Chase
 * @Date: 2025/1/11 19:30
 * @Description: TODO
 **/

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public Student addNewStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @PostMapping("/students")
    public List<Student> addAllStudents(@RequestBody List<Student> studentList){
        return studentService.saveAllStudents(studentList);
    }

    @DeleteMapping("/student")
    public void deleteStudentById(long id){
        studentService.deleteById(id);
    }
}
