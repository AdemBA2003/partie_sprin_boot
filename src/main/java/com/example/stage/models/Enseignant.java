package com.example.stage.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Enseignant")

public class Enseignant implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer id ;
	public String Nom ; 
	public String Prenom ; 
	public String list_gard ; 
	public String list_departement ;

	
	

	public Enseignant() {
	}

	public Integer getId() {
	return id;
}


	public void setId(Integer id) {
	this.id = id;
	}
	
	
	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getList_gard() {
		return list_gard;
	}

	public void setList_gard(String list_gard) {
		this.list_gard = list_gard;
	}

	public String getList_departement() {
		return list_departement;
	}

	public void setList_departement(String list_departement) {
		this.list_departement = list_departement;
	} 
	
	 
	
	
	
	

}
