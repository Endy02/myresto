package com.myresto.domaine;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@EnableAutoConfiguration
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long idProduit;
	private String libelle;
	private double prix;
	
	//Constructors
	public Produit(Long id, Long idProduit, String libelle, double prix) {
		super();
		this.id = id;
		this.idProduit = idProduit;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public Produit() {
		super();	
	}
	
	public Produit(Long id, String libelle, double prix) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
	}

	//Getters
	public Long getId() {
		return id;
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public String getLibelle() {
		return libelle;
	}

	public double getPrix() {
		return prix;
	}

	//Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	
	

}
