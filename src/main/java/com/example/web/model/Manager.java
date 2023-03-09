
package com.example.web.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Manager")
public class Manager extends Personne{

	@SuppressWarnings("unused")
	private String nombreProjets;
}
