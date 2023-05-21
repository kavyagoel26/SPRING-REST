package com.learn.springbootsecuritylearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learn.springbootsecuritylearn.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByUsername(String username);


}
