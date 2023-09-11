package com.broadway.SpringJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.broadway.SpringJPA.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByNameAndPassword(String un,String psw);
	
}
