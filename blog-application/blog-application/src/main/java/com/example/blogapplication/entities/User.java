package com.example.blogapplication.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "username", nullable=false, length=100)
	private String name;
	private String email;
	private String password;
	private String about;
	
}

//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-devtools</artifactId>
//<scope>runtime</scope>
//<optional>true</optional>
//</dependency>


