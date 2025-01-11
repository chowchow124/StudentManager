package com.chase.StudentManager;

import com.chase.StudentManager.dao.Student;
import com.chase.StudentManager.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagerApplication.class, args);
	}

}
