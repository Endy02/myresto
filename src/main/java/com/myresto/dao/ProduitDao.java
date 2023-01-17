package com.myresto.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.myresto.domaine.Produit;

public class ProduitDao implements IProduitDao{

	private JdbcTemplate jdbcTemplate;
	
	public ProduitDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//Read
	//CREATE
	public void createProduit(Produit p) {
		
	}
	//UPDATE
	//DELETE
	
}
