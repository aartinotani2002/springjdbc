package com.spring.jdbc.dao;

import com.spring.jdbc.entites.Student;

public interface Studentdao {
	public int insert(Student student);
	public int change(Student student);
}
