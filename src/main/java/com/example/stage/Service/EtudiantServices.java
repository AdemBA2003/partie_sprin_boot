package com.example.stage.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stage.Repository.EtudiantRepository;
import com.example.stage.models.Etudiant;

import jakarta.transaction.Transactional;
@Service

public class EtudiantServices implements IEtudiantService {
	
	@Autowired 
	EtudiantRepository etudiantRepository ;

	@Override
	public void ajouterEtudiant(Etudiant etudiant) {
		etudiantRepository.save(etudiant);
		
	}

	@Override
	public List<Etudiant> affiche() {
		List<Etudiant> E= etudiantRepository.findAll();
		
		return E ; 
		
	}

	@Override
	@Transactional
	public void supprimerParId(Long Id) {
		etudiantRepository.deleteById(Id);
		
	}

	@Override
	public Etudiant editEtudiant (Etudiant E)  throws RuntimeException  {
	
		{
			  if (E.getId() == null) {
			   throw new IllegalArgumentException("Id n peut pas etre null ");
			  }
			  if (E.getName() == null || E.getName().isEmpty()) {
			   throw new IllegalArgumentException("name ne peut pas etre null ");
			  }
			  
			  if (E.getPrenom() == null || E.getPrenom().isEmpty()) {
				   throw new IllegalArgumentException("Prenom ne peut pas etre null");
				  }
			  try {
			   return etudiantRepository.save(E);
			  } catch (Exception E1) {
			   throw new RuntimeException("echoue de modifier un Etudaint", E1);
			  }
			 }
	}

	@Override
	public Etudiant addEtudiant(Etudiant E) {
		if (E.getId() == null || E.getName().isEmpty()) {
			   throw new IllegalArgumentException("Etudiant cannot be empty");
			  }
			  try {
			   return etudiantRepository.save(E);
			  } catch (Exception e) {
			   throw new RuntimeException("Failed to add Etudiant", e);
			  }
			  
			


	}
	@Override
	  public Optional<Etudiant> findEtudiantById(Integer id) {
			// TODO Auto-generated method stub
			Optional<Etudiant> E = etudiantRepository.findById(id);
			
			return E;
		}
	
	
	
	
	
	


}
