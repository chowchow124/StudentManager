package com.chase.StudentManager.service;

import com.chase.StudentManager.dao.Student;

import java.util.List;
import java.util.Optional;

/**
 * @Author: Chase
 * @Date: 2025/1/11 19:06
 * @Description: TODO
 **/
public interface StudentService {
    Student saveStudent(Student student);

    List<Student> saveAllStudents(List<Student> studentList);

    void deleteById(Long id);

    List<Student> findAllStudent();

    Optional<Student> findById(Long id);

    boolean existsById(Long id);

    Long countStudents();

}



