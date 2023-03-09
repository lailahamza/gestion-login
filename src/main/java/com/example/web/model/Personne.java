package com.example.web.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "profil")

public class Personne {
	@Id
	private String code;
	
	@SuppressWarnings("unused")
	private String profil;
	
}
