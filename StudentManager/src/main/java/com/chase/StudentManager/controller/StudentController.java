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
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addNewStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @PostMapping("/batch")
    public List<Student> addAllStudents(@RequestBody List<Student> studentList){
        return studentService.saveAllStudents(studentList);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(long id){
        studentService.deleteById(id);
    }

    @GetMapping("/age/{age}")
    public List<Student> getStudentsByAgeGreaterThan(@PathVariable Integer age){
        return studentService.getStudentByAgeGreaterThan(age);
    }

    @GetMapping("/search")
    public List<Student> searchStudentsByName(@RequestParam String name){
        return studentService.searchStudentsByName(name);
    }

    @GetMapping("/class/{classId}/count")
    public Long countStudentsInClass(@PathVariable Long classId){
        return studentService.countStudentsInClass(classId);
    }

    @GetMapping("/class/{classId}")
    public List<Student> getStudentsByClassId(@PathVariable Long classId){
        return studentService.getStudentsByClassId(classId);
    }

}
