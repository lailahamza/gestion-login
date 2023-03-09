package com.example.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.model.Login;
import com.example.web.model.Role;
import com.example.web.repository.LoginRepository;
import com.example.web.repository.RoleRepository;


@Service
public class LoginService {

	@Autowired
	LoginRepository repo;
	@Autowired
	RoleRepository roleRepo;
	
	
	
	public boolean authentif(String login, String pwd) {
		repo.save(new Login(login,pwd));
		
		return login.equals(pwd);
		
	}
	
	public List<Login> getLogins(){
		return  repo.findAll();
		
		
	}
	
	
	//affecter un role a un login
	public void affectRoleToLogin(Login login, Role role) {
		roleRepo.save(role);
			
		//affecter
			login.setRole(role);
			repo.save(login);
	}
	
	public List<Login> getLogin(){
		return roleRepo.getLogins();
	}
	
	public Role getRoleByIntitule(String intitule) {		
		return roleRepo.getByIntitule(intitule).get(0);
	}
	
	public List<Login> getLoginsRole(String intitule){
		return roleRepo.getLoginsRole(intitule);
	}
	
	public List<Object[]> getNombreLoginsByRole(){
		return roleRepo.getNombreLoginsByRole();
		
	}
}
