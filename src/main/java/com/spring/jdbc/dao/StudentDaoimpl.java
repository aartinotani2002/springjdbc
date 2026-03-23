package com.spring.jdbc.dao;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entites.Student;

public class StudentDaoimpl implements Studentdao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {
		// creating
        String query="insert into student(id , name , city) values(?,?,?)";
        int r =this.jdbcTemplate.update(query , student.getId(), student.getName() , student.getCity());
        
		return r;
	}
	
	@Override
	public int change(Student student) {
		// updating 
		String query = "update student set name=? , city=? where id=?";
		int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}
	
	@Override
	public int delete(Student student) {
		// delete
		String query = "delete from student where id =?";
		int r = this.jdbcTemplate.update(query,student.getId());
		return r;
	}

	@Override
	public Student getStudent(int studentId) {
		// Selecting single student data
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperimp();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper , studentId);
		return student;
	}



	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

		
	
	
}
