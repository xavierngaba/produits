package com.xavier.produits.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xavier.produits.dto.ProduitDTO;
import com.xavier.produits.entities.Categorie;
import com.xavier.produits.entities.Produit;
import com.xavier.produits.repos.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService {
	
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ProduitDTO saveProduit(ProduitDTO p) {
		return convertEntityTODto(produitRepository.save(convertDtoToEntity(p)));
	}

	@Override
	public ProduitDTO updateProduit(ProduitDTO p) {
		return convertEntityTODto(produitRepository.save(convertDtoToEntity(p)));
	}

	@Override
	public void deleteProduit(Produit p) {
		produitRepository.delete(p);
	}

	@Override
	public void deleteProduitById(Long id) {
		produitRepository.deleteById(id);
	}

	@Override
	public ProduitDTO getProduit(Long id) {
		return convertEntityTODto(produitRepository.findById(id).get());
	}

	@Override
	public List<ProduitDTO> getAllProduits() {
		return produitRepository.findAll().stream()
				.map(this::convertEntityTODto)
				.collect(Collectors.toList());
	}

	@Override
	public List<Produit> findByNomProduit(String nomProduit) {
		return produitRepository.findByNomProduit(nomProduit);
	}

	@Override
	public List<Produit> findByNomProduitContains(String nomProduit) {
		return produitRepository.findByNomProduitContains(nomProduit);
	}

	@Override
	public List<Produit> findByNomPrix(String nom, Double prix) {
		return produitRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Produit> findByCategorie(Categorie categorie) {
		return produitRepository.findByCategorie(categorie);
	}

	@Override
	public List<Produit> findByCategorieIdCat(Long id) {
		return produitRepository.findByCategorieIdCat(id);
	}

	@Override
	public List<Produit> findByOrderByNomProduitAsc() {
		return produitRepository.findByOrderByNomProduitAsc();
	}

	@Override
	public List<Produit> trierProduitsNomsPrix() {
		return produitRepository.trierProduitsNomsPrix();
	}

	@Override
	public ProduitDTO convertEntityTODto(Produit produit) {
		
		/*return ProduitDTO.builder()
				.idProduit(p.getIdProduit())
				.nomProduit(p.getNomProduit())
				.prixProduit(p.getPrixProduit())
				.categorie(p.getCategorie())
				//.nomCat(p.getCategorie()!= null ? p.getCategorie().getNomCat() : "N/A")
				.dateCreation(p.getDateCreation())
				.build();*/
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ProduitDTO produitDTO = modelMapper.map(produit, ProduitDTO.class);
	    return produitDTO;
	}

	@Override
	public Produit convertDtoToEntity(ProduitDTO dto) {
		/*return Produit.builder()
			   .idProduit(dto.getIdProduit())
			   .nomProduit(dto.getNomProduit())
			   .prixProduit(dto.getPrixProduit())
			   .dateCreation(dto.getDateCreation())
			   .categorie(dto.getCategorie())
			   .build();*/
		
		Produit produit = new Produit();
		produit = modelMapper.map(dto, Produit.class);
		return produit;
	}

}
