package com.example.day1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name ="Student")
public class Student {
	
	@jakarta.persistence.Id
	private int Id;
	private String Name;
	private String Course;
	private int Batch_Year;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	public int getBatch_Year() {
		return Batch_Year;
	}
	public void setBatch_Year(int batch_Year) {
		Batch_Year = batch_Year;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, String course, int batch_Year) {
		super();
		Id = id;
		Name = name;
		Course = course;
		Batch_Year = batch_Year;
	}
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", Name=" + Name + ", Course=" + Course + ", Batch_Year=" + Batch_Year + "]";
	}
	

}
