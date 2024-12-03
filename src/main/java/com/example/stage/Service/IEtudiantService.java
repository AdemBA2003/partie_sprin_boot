package com.example.stage.Service;

import java.util.List;
import java.util.Optional;

import com.example.stage.models.Etudiant;

public interface IEtudiantService {
	
	void ajouterEtudiant(Etudiant etudiant );
	
	List<Etudiant>affiche();
	
	public void supprimerParId(Long Id);
	
	 public Etudiant editEtudiant(Etudiant E);

	 

	Etudiant addEtudiant(Etudiant E);

	



	Optional<Etudiant>  findEtudiantById(Integer id);

}
