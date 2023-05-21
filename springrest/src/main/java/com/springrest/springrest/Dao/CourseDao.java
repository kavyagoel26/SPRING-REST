package com.springrest.springrest.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.springrest.springrest.Entity.Course;

public interface CourseDao extends JpaRepository<Course, Long>{



	List<Course> findAll();

	Course findAllById(long parseLong);

	Object findBytitle(String title);
	
	public List<Course> findByTitle(String title);







}
