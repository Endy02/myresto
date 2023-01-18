package com.myresto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myresto.domaine.Produit;
import com.myresto.service.ProduitService;

@RestController
public class ProduitController {
	
	@Autowired
	private ProduitService produitService;
	
	@PostMapping("/Produit")
	public void create(@RequestBody Produit p) {
		produitService.createProduit(p);
	}
		
	@PutMapping("/Produit")
	public void update(@RequestBody Produit p) {
		produitService.updateProduit(p);
	}
	
	@DeleteMapping("/Produit")
	public void delete(@RequestBody int id) {
		produitService.deleteProduit(id);
	}
	
	@GetMapping("/Produit")
	public List<Produit> get(){
		return produitService.getAllProducts();
	}
}
