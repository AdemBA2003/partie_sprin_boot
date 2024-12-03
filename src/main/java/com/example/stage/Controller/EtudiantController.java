package com.example.stage.Controller;


import java.util.List;
import java.util.Optional;

import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.example.stage.Service.EtudiantServices;
import com.example.stage.models.Etudiant;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping
public class EtudiantController {
	
	@Autowired
	EtudiantServices etudiantService ; 
	
	
	@GetMapping("/Etudiant")
	public List<Etudiant>getEtudiant()
	{
		return etudiantService.affiche();
	}
	
	
	@PostMapping("/ajout")
		
		public void ajouterEtudiant(@RequestBody Etudiant etudiant)
		{
			etudiantService.ajouterEtudiant(etudiant);
		}
	
	  @DeleteMapping("Delete/{Id}")
	    public void deleteEtudiant (@PathVariable Long Id) {
		  etudiantService.supprimerParId(Id);
	        
	    }
	  @GetMapping("/retrieve-etudiant/{etudiant-id}")
		@ResponseBody
		public Optional<Etudiant>  retrievEtudiant(@PathVariable("etudiant-id") Integer EtudiantId) {
		return etudiantService.findEtudiantById(EtudiantId);
		}

	  
	  @PutMapping("/edit-Etudiant")
	  public Etudiant editProduct(@RequestBody Etudiant E) {
	   return etudiantService.editEtudiant(E);
	  }
	  
	  @PostMapping("/add-Etudiant")
	  public Etudiant addEtudiant(@RequestBody Etudiant E) {
	   return etudiantService.addEtudiant(E);
	  }

}
