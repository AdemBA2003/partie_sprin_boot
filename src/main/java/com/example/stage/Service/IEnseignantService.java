package com.example.stage.Service;

import java.util.List;
import java.util.Optional;

import com.example.stage.models.Enseignant;
import com.example.stage.models.Etudiant;

public interface IEnseignantService {

	void  ajouterEnseignant(Enseignant enseignant);

	List<Enseignant> affichage();
	Enseignant addEnseignant(Enseignant E);
	


	void supprimerParId(Integer id);

	Optional<Enseignant> findEnsgById(Integer id);

	Enseignant editEnseignant(Enseignant E) throws RuntimeException;	
}
