package com.myresto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	//Login
	@RequestMapping("/register")
	public String register() {
		return "Register";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}
	
	
	//Pages Visiteurs
	@RequestMapping("/*")
	public String home() {
		return "Home page (Tableau de bord)";
	}
	
	@RequestMapping("/mesCommandes")
	public String mesCommandes() {
		return "Mes Commandes";
	}
	
	@RequestMapping("/paiement")
	public String paiement() {
		return "page de paiement";
	}
	
	@RequestMapping("/recap")
	public String recap() {
		return "Page validation paiement et recap de la commande";
	}
	
	@RequestMapping("/mon-profil")
	public String monProfil() {
		return "Mon Profil";
	}
	
	
	//Pages Gerant
	@RequestMapping("gerant/*")
	public String homeGerant() {
		return "Page home du gérant";
	}
	@RequestMapping("gerant/clients")
	public String clients() {
		return "Liste des clients";
	}
	
	@RequestMapping("gerant/commandes")
	public String commandes() {
		return "Liste des commandes";
	}
	
	
	
	


}
