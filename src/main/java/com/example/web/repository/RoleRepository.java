package com.example.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.web.model.Login;
import com.example.web.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	//Requet personnalisée
	@Query("SELECT e from Login e")
	List<Login> getLogins();
	
	//extraction personnalisée par attribut
	List<Role> getByIntitule(String intitule);
	
	@Query("select l from Role r join r.logins l where r.intitule=:abc")
	public List<Login> getLoginsRole(@Param("abc") String intitule);


	@Query("select r.intitule, count(l) from Role r join r.logins l group by r.intitule")
	public List<Object[]> getNombreLoginsByRole();
}
