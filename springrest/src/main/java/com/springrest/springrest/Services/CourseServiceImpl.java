package com.springrest.springrest.Services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springrest.springrest.Dao.CourseDao;
import com.springrest.springrest.Entity.Course;
import com.springrest.springrest.customexception.BussinessException;


@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;
	private Object list;

	public CourseServiceImpl() {
	}

	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
//		try {
//			if(CourseDao.getTitle().isEmpty() || CourseDao.getTitle().length()==0);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		throw new BussinessException("601","Please send proper title");
	}
	
	public List<Course> getCoursesWithSort(String field){
		return courseDao.findAll(Sort.by(Sort.Direction.ASC,field));
		
	}
	
	public Page<Course> getCoursesWithPagination(int offset, int pageSize){
		Page<Course> courses = courseDao.findAll(PageRequest.of(offset, pageSize));
		return courses;
	}

	@Override
	public Course getCourse(long courseId) {
    	return courseDao.findAllById(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		courseDao.save(course);
		return course;
	}
	
	public void addCourses(Course course , long courseId) {
//		list = list.stream().map(b->{
//			if(b.getId()==courseId) {
//				b.setTitle(course.getTitle());
//				b.setDescription(course.getDescription());
//			}
//			return b;
//		}).collect(Collectors.toList());
//	
		
		Course addCourses = courseDao.getById(courseId);
		addCourses.setTitle(course.getTitle());
        addCourses.setDescription(course.getDescription());

        courseDao.save(addCourses);

	}
		

	@Override
	public void deleteCourse(long parseLong) {
		//Course entity=courseDao.findAllById(parseLong);
	    courseDao.deleteById(parseLong);
	
		
	}}
