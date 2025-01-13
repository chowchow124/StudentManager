package com.chase.StudentManager.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.chase.StudentManager.dao.Student;
import com.chase.StudentManager.dao.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

/**
 * @Author: Chase
 * @Date: 2025/1/13 11:09
 * @Description: TODO
 **/
public class StudentServiceImplTest {

    @InjectMocks   //创建并注入被测试类的依赖
    private StudentServiceImpl studentService;

    @Mock    //避免与实际数据库交互
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);  //初始化上面俩注解
    }

    @Test
    void testSaveStudent(){
        Student student = new Student(1L,"Tom",20,33L);
        when(studentRepository.save(student)).thenReturn(student);

        Student result = studentService.saveStudent(student);

        assertNotNull(result);
        assertEquals("Tom",result.getName());
        verify(studentRepository,times(1)).save(student);
    }

    @Test
    void testSaveAllStudents(){
        List<Student> students = Arrays.asList(
                new Student(1L,"Tom",18,23L),
                new Student(2L,"Jerry",19,33L)
        );
        when(studentRepository.saveAll(students)).thenReturn(students);

        List<Student> result = studentService.saveAllStudents(students);

        assertNotNull(result);
        assertEquals(2,result.size());
        verify(studentRepository,times(1)).saveAll(students);
    }

    @Test
    void testDeleteById(){
        studentService.deleteById(1L);

        verify(studentRepository,times(1)).deleteById(1L);

    }

    @Test
    void testGetStudentByAgeGreaterThan() {
        List<Student> students = Arrays.asList(
                new Student(1L, "Charlie", 22,10L),
                new Student(2L, "Dave", 25,23L)
        );
        when(studentRepository.findByAgeGreaterThan(20)).thenReturn(students);

        List<Student> result = studentService.getStudentByAgeGreaterThan(20);

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(studentRepository, times(1)).findByAgeGreaterThan(20);
    }

    @Test
    void testSearchStudentsByName() {
        List<Student> students = Arrays.asList(
                new Student(1L, "Alice Smith", 18,23L),
                new Student(2L, "Alice Johnson", 19,12L)
        );
        when(studentRepository.findStudentsByNameContaining("Alice")).thenReturn(students);

        List<Student> result = studentService.searchStudentsByName("Alice");

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(studentRepository, times(1)).findStudentsByNameContaining("Alice");
    }

    @Test
    void testCountStudentsInClass() {
        when(studentRepository.countStudentsByClassId(1L)).thenReturn(5L);

        Long count = studentService.countStudentsInClass(1L);

        assertNotNull(count);
        assertEquals(5L, count);
        verify(studentRepository, times(1)).countStudentsByClassId(1L);
    }

    @Test
    void testGetStudentsByClassId() {
        List<Student> students = Arrays.asList(
                new Student(1L, "Fiona", 20,10L),
                new Student(2L, "Frank", 21,23L)
        );
        when(studentRepository.findStudentsByClassId(1L)).thenReturn(students);

        List<Student> result = studentService.getStudentsByClassId(1L);

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(studentRepository, times(1)).findStudentsByClassId(1L);
    }

}
