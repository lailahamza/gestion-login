package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, String> {
	

}
