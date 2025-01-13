package com.chase.StudentManager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: Chase
 * @Date: 2025/1/11 18:46
 * @Description: TODO
 **/
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByAgeGreaterThan(Integer age);

    @Query("SELECT s FROM Student s WHERE s.name LIKE %?1%")
    List<Student> findStudentsByNameContaining(String namePart);

    @Query("SELECT COUNT(s) FROM Student s WHERE s.classId = ?1")
    Long countStudentsByClassId(Long classId);

    @Query("SELECT s FROM Student s WHERE s.classId = ?1")
    List<Student> findStudentsByClassId(Long classId);


}
