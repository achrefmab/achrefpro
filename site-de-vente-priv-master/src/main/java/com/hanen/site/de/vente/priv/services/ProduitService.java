package com.hanen.site.de.vente.priv.services;

import java.util.List;


import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.hanen.site.de.vente.priv.model.Produit;



public interface ProduitService {
	
	
	List<Produit> getAllProduits();

	 Optional<Produit> getProduitById(Long produitId);

	Produit createProduit(Produit produit);	

	Produit updateProduit(Produit produitDetails);

	void deleteProduit(Produit produit);
	

}
