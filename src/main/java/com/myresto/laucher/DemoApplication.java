package com.myresto.laucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myresto.domaine.Produit;
import com.myresto.service.ProduitService;

@SpringBootApplication(scanBasePackages="com.myresto")
@RestController
public class DemoApplication {
	
	@Autowired
	private ProduitService produitService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@GetMapping("/test")
	public String hello() {
		Produit p= new Produit(2,"Banane",2.65);
		produitService.createProduit(p);
		
	return String.format("tamer");
	}
	
}
