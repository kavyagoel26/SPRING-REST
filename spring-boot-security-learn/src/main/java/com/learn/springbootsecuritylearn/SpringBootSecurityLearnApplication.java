package com.learn.springbootsecuritylearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.learn.springbootsecuritylearn.model.User;
import com.learn.springbootsecuritylearn.repository.UserRepository;

@SpringBootApplication(scanBasePackages = {"com.learn.springbootsecuritylearn"})
public abstract class SpringBootSecurityLearnApplication {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityLearnApplication.class, args);
	}
	
	public void run(String... args) throws Exception{
		User user = new User();
		user.setEmail("john@gmail.com");
		user.setUsername("john");
		user.setPassword(this.bCryptPasswordEncoder.encode("Hello"));
		user.setRole("ROLE_NORMAL");
		this.userRepository.save(user);
		
		User user1 = new User();
		user.setEmail("roshni@gmail.com");
		user.setUsername("ram");
		user.setPassword(this.bCryptPasswordEncoder.encode("Hello"));
		user.setRole("ROLE_ADMIN");
		this.userRepository.save(user1);
		

}

}
