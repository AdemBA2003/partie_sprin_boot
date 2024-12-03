package com.example.stage.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.stage.Service.EnseignantService;
import com.example.stage.models.Enseignant;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping
public class EnseignantController {

	@Autowired
	EnseignantService enseignantService;

	@GetMapping("/Enseignant")
	public List<Enseignant> getEnseignant() {
		return enseignantService.affichage();
	}

	@PostMapping("/ajouter")
	public void ajouterEnseignant(@RequestBody Enseignant enseignant) {
		enseignantService.ajouterEnseignant(enseignant);
	}

	@GetMapping("/count")
	public long getNombreEnseignants() {
		return enseignantService.countEnseignants();
	}

	// @DeleteMapping("Delete-Enseignant/{id}")
	// public void deleteEtudiant (@PathVariable Integer id) {
	// enseignantService.supprimerParId(id);

	// }

	@DeleteMapping("Delete-Enseignant/{id}")
	public void deleteEtudiant(@PathVariable Integer id) {
		System.out.println("Suppression demandée pour l'ID : " + id);
		try {
			enseignantService.supprimerParId(id);
			System.out.println("Suppression réussie pour l'ID : " + id);
		} catch (Exception e) {
			System.err.println("Erreur lors de la suppression pour l'ID " + id + ": " + e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erreur lors de la suppression", e);
		}
	}

	@GetMapping("/retrieve-Enseignant/{enseignant-id}")
	@ResponseBody
	public Optional<Enseignant> retrievEtudiant(@PathVariable("enseignant-id") Integer EnseignantId) {
		return enseignantService.findEnsgById(EnseignantId);
	}
	  @PutMapping("/edit-Enseignant")
	  public Enseignant editProduct(@RequestBody Enseignant E) {
	   return enseignantService.editEnseignant(E);
	  }
	  
	  
	 
	  
	  
	  
	  
}
