package com.example.blogapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blogapplication.entities.User;

public interface UserRepository extends JpaRepository<User , Integer> {

}
