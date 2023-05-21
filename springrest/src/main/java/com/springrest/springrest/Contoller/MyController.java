package com.springrest.springrest.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.Dao.CourseDao;
import com.springrest.springrest.Entity.Course;
import com.springrest.springrest.Services.CourseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@CrossOrigin
public class MyController {
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CourseDao courseDao;
	
	@Operation(summary = "This is to fetch All the Books stored in Db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "Fetched All the Books form Db",
            content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
            description = "NOt Available",
            content = @Content)
    })
	
	
	//get the courses 
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseService.getCourses();
		
	}
	//Sorting by diffrent feilds
	@GetMapping("/courses/field/{field}")
	public List<Course> getCoursesWithSort(@PathVariable String field){
		return this.courseService.getCoursesWithSort(field);
		
	}
	//pageination
	@GetMapping("/courses/page/{offset}/{pageSize}")
	public Page<Course> getCoursesWithPagination(@PathVariable int offset, @PathVariable int pageSize){
		return this.courseService.getCoursesWithPagination(offset,pageSize);
		
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping(path= "/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);	
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
	@PutMapping("/courses/{courseId}")
	public Course addCourses(@RequestBody Course course, @PathVariable("courseId") long courseId ) {
		 this.courseService.addCourses(course,courseId);
		 return course;
	}
//	public ResponseEntity<Course> addCourses(@PathVariable Long courseId,@RequestBody Course courseDetails) {
//        return ResponseEntity.ok(addCourses(null));
//    }

	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@GetMapping("/courses/search/{query}")
	public ResponseEntity<?> search(@PathVariable("query") String query){
		System.out.println(query);
		List<Course> courses= this.courseDao.findByTitle(query);
		return ResponseEntity.ok(courses);
		
	}

}
