package com.example.web.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data @AllArgsConstructor @NoArgsConstructor 
public class Login {
	@Id
	@Column(length = 20)
	private String login;
	private String pwd;
	
	@ManyToOne
	Role role;

	public Login(String login, String pwd) {
		this.login = login;
		this.pwd = pwd;
	}

	
	
	
}
