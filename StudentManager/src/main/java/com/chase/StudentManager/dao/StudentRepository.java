package com.chase.StudentManager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Chase
 * @Date: 2025/1/11 18:46
 * @Description: TODO
 **/
public interface StudentRepository extends JpaRepository<Student,Long> {
}
