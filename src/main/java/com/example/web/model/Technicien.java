package com.example.web.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Technicien")
public class Technicien extends Personne{

	@SuppressWarnings("unused")
	private String domaine;
}
