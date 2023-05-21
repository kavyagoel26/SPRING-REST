package com.example.day1.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day1.Service.StudentService;
import com.example.day1.entity.Student;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/String")
	public String getSting() {
		return "Student Information";
	}
	@GetMapping("/list")
	public List<String> getList(){
		List<String> list = Arrays.asList("Student");
		return list;
	}
	@GetMapping("/object")
	public List<Student> getObject(){
		List<Student> studentList = Arrays.asList(
				new Student(1, "Abhay" , "science" , 2018-2019),
				new Student(1, "Abhay" , "science" , 2018-2019)
				);
		return studentList;
	}
	@GetMapping("/object/service")
	public List<Student> getObject3(){
		return service.getAllStudent();
	}
	
//	@GetMapping("/objectById/{id}")
//	public List<Student> getStudentById(@PathVariable int id){
//		return service.getStudentsById(id);
//	}
	
	@PostMapping("/add")
	public void addStudent(@RequestBody Student student) {
		service.getAddStudent(student);
	}
	
	@PutMapping("/update")
	public String updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}

}
