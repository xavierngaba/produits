package com.xavier.produits.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xavier.produits.entities.Categorie;
import com.xavier.produits.service.CategorieService;


@RestController
@RequestMapping("/api/categorie")
public class CategorieRESTController {

	@Autowired
	CategorieService categorieService;
	
	@PostMapping("/creer")
	public ResponseEntity<Categorie> createCategorie (@RequestBody Categorie cat) {
		return ResponseEntity.ok(categorieService.saveCategorie(cat));
	}
}
