package com.example.web.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Role {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String intitule;
	
	@OneToMany(mappedBy = "role")
	List<Login> logins;
	
	@ManyToMany(mappedBy = "roles")
	List<Privilege> privileges  = new ArrayList<>();
}
