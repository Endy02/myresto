package com.myresto.laucher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myresto.domaine.CommandeProduit;
import com.myresto.domaine.Produit;
import com.myresto.service.CommandeProduitService;
import com.myresto.service.ProduitService;

@SpringBootApplication(scanBasePackages="com.myresto")
@RestController
public class DemoApplication {
	
	@Autowired
	private ProduitService produitService;
	
	@Autowired
	private CommandeProduitService commandeProduitService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@GetMapping("/test")
	public String hello() {
		/*Produit p= new Produit(2,"Banane",2.65);
		produitService.createProduit(p);*/
		CommandeProduit commandeP =new CommandeProduit(1,1,2,false);
		int [] idProduits= {1,2};
		commandeP.setIdProduit(idProduits);
		//commandeProduitService.createCommandeProduit(commandeP);
		List<CommandeProduit> list=commandeProduitService.getAllCommandeProduit();
		for(CommandeProduit cp:list) {
			System.out.println("commande numero cp:"+cp.getIdCommande());
			for(Produit P:cp.getProduits()) {
				System.out.println("produits:"+ P.getLibelle());
			}
		}
		//commandeProduitService.deleteCommandeProduit(1);
		
		
	return String.format("tamer");
	}
	
}
