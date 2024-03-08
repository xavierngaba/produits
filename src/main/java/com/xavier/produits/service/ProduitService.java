package com.xavier.produits.service;

import java.util.List;

import com.xavier.produits.dto.ProduitDTO;
import com.xavier.produits.entities.Categorie;
import com.xavier.produits.entities.Produit;

public interface ProduitService {

	ProduitDTO saveProduit(ProduitDTO p);
	ProduitDTO updateProduit(ProduitDTO p);
	ProduitDTO getProduit(Long id);
	List<ProduitDTO> getAllProduits();
	
	
	void deleteProduit(Produit p);
	void deleteProduitById(Long id);
	
	
	List<Produit> findByNomProduit(String nomProduit);
	List<Produit> findByNomProduitContains(String nomProduit);
	List<Produit> findByNomPrix(String nom,Double prix);
	List<Produit> findByCategorie (Categorie categorie);
	List<Produit> findByCategorieIdCat(Long id);
	List<Produit> findByOrderByNomProduitAsc();
	List<Produit> trierProduitsNomsPrix();
	
	ProduitDTO convertEntityTODto(Produit p);
	Produit convertDtoToEntity(ProduitDTO dto);
}
