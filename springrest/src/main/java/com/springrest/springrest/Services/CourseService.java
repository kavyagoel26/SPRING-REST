package com.springrest.springrest.Services;

import java.util.List;

import com.springrest.springrest.Entity.Course;

public interface CourseService {
	
	public List<Course> getCourses();

	public Course getCourse(long courseId);

	public Course addCourse(Course course);

	public Course updateCourse(Course course);

	public void deleteCourse(long parseLong);

	public void addCourses(Course course, long courseId);

	public List<Course> getCoursesWithSort(String field);

	public org.springframework.data.domain.Page<Course> getCoursesWithPagination(int offset, int pageSize);

}
