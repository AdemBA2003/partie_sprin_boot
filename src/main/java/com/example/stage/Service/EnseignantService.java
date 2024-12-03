package com.example.stage.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stage.Repository.EnseignantRepository;
import com.example.stage.models.Enseignant;
import com.example.stage.models.Etudiant;

import jakarta.transaction.Transactional;

import org.springframework.dao.DataAccessException;

@Service
public class EnseignantService implements IEnseignantService {
	@Autowired
	EnseignantRepository enseignantRepository;

	@Override
	public List<Enseignant> affichage() {
		List<Enseignant> L = enseignantRepository.findAll();
		return L;
	}

	@Override
	public void ajouterEnseignant(Enseignant enseignant) {
		enseignantRepository.save(enseignant);
	}

	@Override
	public Enseignant addEnseignant(Enseignant E) {
		if (E.getId() == 0) {
			throw new IllegalArgumentException("Etudiant cannot be empty");
		}
		try {
			return enseignantRepository.save(E);
		} catch (Exception e) {
			throw new RuntimeException("Failed to add product", e);
		}

	}

	public long countEnseignants() {
		return enseignantRepository.count();
	}

	@Override
	public Optional<Enseignant> findEnsgById(Integer id) {

		// TODO Auto-generated method stub
		Optional<Enseignant> E = enseignantRepository.findById(id);

		return E;

	}

	@Override
	@Transactional
	public void supprimerParId(Integer Id) {
		enseignantRepository.deleteById(Id);

	}

	@Override
	public Enseignant editEnseignant(Enseignant E) throws RuntimeException {
		{

			if (E.getId() == null) {
				throw new IllegalArgumentException("Id n peut pas etre null ");
			}
			if (E.getPrenom() == null || E.getPrenom().isEmpty()) {
				throw new IllegalArgumentException("name ne peut pas etre null ");
			}

			if (E.getNom() == null || E.getNom().isEmpty()) {
				throw new IllegalArgumentException("Prenom ne peut pas etre null");
			}
			try {
				return enseignantRepository.save(E);
			} catch (Exception E1) {
				throw new RuntimeException("echoue de modifier un EnseignantEnseignant", E1);
			}
		}
	}

}
