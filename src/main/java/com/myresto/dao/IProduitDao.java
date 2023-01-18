package com.myresto.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myresto.domaine.Commande;
import com.myresto.domaine.Produit;

@Service
public interface IProduitDao {
	List<Produit> getAllProducts();
	void createProduit(Produit p);
	Produit getProduitById( int id );
	void updateProduit(Produit p);
	void deleteProduit(int id);
}
