package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.Studentdao;
import com.spring.jdbc.entites.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("My program started");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		Studentdao studentdao = context.getBean(Studentdao.class);

		/*
		 * Student student = new Student(); student.setId(4); int result =
		 * studentdao.delete(student); System.out.println("Deleted "+result);
		 * 
		 * student.setId(2); student.setName("Manoj Kumar");
		 * student.setCity("Bangalore"); int result = studentdao.change(student);
		 * System.out.println("Data Changed "+result);
		 * 
		 * 
		 * student.setId(4); student.setName("Aadi"); student.setCity("Nashik");
		 * 
		 * int result = studentdao.insert(student); System.out.println("Student added :"
		 * + result);
		 */
		Student student = studentdao.getStudent(2);
		System.out.println(student);
		
		List<Student> allStudent = studentdao.getAllStudent();
		for(Student s : allStudent) {
			System.out.println(s);
		}
	}
}
