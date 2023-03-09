package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.web.model.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, String> {

}
