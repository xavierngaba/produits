package com.xavier.produits.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xavier.produits.dto.ProduitDTO;
import com.xavier.produits.entities.Produit;
import com.xavier.produits.service.ProduitService;

@RestController
@RequestMapping("/api")
public class ProduitRESTController {
	
	@Autowired
	ProduitService produitService;
	
	@GetMapping
	List<ProduitDTO> getAllProduits() {
		return produitService.getAllProduits();
	}
	
	@GetMapping(value = "/{id}")
	public ProduitDTO getProduitById(@PathVariable("id") Long id) {
		return produitService.getProduit(id);
	}
	
	@PostMapping("/creer")
	public ResponseEntity<ProduitDTO> createProduit(@RequestBody ProduitDTO produitDTO) {
		return ResponseEntity.ok(produitService.saveProduit(produitDTO));
	}
	
	@PatchMapping("/update")
	public ResponseEntity<ProduitDTO> updateProduit(@RequestBody ProduitDTO produitDTO) {
		return ResponseEntity.ok(produitService.updateProduit(produitDTO));
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteProduit(@PathVariable("id") Long id) {
		produitService.deleteProduitById(id);
	}
	
	@GetMapping(value = "/prodscat/{idCat}")
	public List<Produit> getProduitByCatId(@PathVariable("idCat") Long idCat) {
		return produitService.findByCategorieIdCat(idCat);
	}

}
