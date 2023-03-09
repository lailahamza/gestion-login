package com.example.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.model.Privilege;
import com.example.web.model.Role;
import com.example.web.repository.PrivilegeRepository;
import com.example.web.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PrivilegeRepository privilegeRepository;
	
	
	public void affecterrivilegeRole(Privilege prv, Role role) {
		
		roleRepository.save(role);
		prv.getRoles().add(role);
		privilegeRepository.save(prv);		
	}
}
