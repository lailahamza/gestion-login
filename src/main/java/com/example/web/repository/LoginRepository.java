package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.web.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String>{

	
}
