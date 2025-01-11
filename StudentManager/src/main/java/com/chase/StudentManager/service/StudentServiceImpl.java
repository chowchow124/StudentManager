package com.chase.StudentManager.service;

import com.chase.StudentManager.dao.Student;
import com.chase.StudentManager.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author: Chase
 * @Date: 2025/1/11 19:07
 * @Description: TODO
 **/

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> saveAllStudents(List<Student> studentList) {
        return studentRepository.saveAll(studentList);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return studentRepository.existsById(id);
    }

    @Override
    public Long countStudents() {
        return studentRepository.count();
    }
}
