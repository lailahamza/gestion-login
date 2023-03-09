package com.example.web.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Privilege {

	@Id
	@Column(length = 30)
	private String intitule;
	
	@ManyToMany
	List<Role> roles = new ArrayList<Role>();
	
}
