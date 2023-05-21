package com.example.day1.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.day1.entity.Student;

@Service
public class StudentService {
	
	private List<Student> loadStudentFromDb(){
		List<Student> studentObject = new ArrayList<Student>();
		studentObject.add(new Student(1, "Abhay" , "science" , 2018-2019));
				studentObject.add(new Student(2, "Sonia" , "maths" , 2018-2019));
		return studentObject;
	}
	private List<Student> students = loadStudentFromDb();
  
	public List<Student> getStudentsById(int id) {
		return getAllStudent().stream().filter(student -> student.getId() == id)
				.collect(Collectors.toList());
	}

	public List<Student> getAllStudent() {
		return students;
	}

	public void getAddStudent(Student student) {
		students.add(student);
		
	}

	public String updateStudent(Student student) {
		//exist in the student object - yes -update , no- create/add
		boolean resourceFound = false;
		for(Student studentList: students) {
			if(studentList.getId() == student.getId()) {
				resourceFound=true;
				studentList.setId(student.getId());
				studentList.setName(student.getName());
				studentList.setCourse(student.getCourse());
				studentList.setBatch_Year(student.getBatch_Year());
			}
		}
		if(!resourceFound) {
			students.add(student);
			return "student has been created!!";
		}
		return "student has been updated";
		
	}

}
