package com.myresto.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.myresto.dao.IProduitDao;
import com.myresto.domaine.Produit;

public class ProduitService {
	
	@Autowired
	private IProduitDao iProduitDao;
	
	public ProduitService() {
	}

	public ProduitService(IProduitDao iProduitDao) {
		super();
		this.iProduitDao = iProduitDao;
	}
	
	public void createProduit(Produit p) {
		iProduitDao.createProduit(p);
	}

}
