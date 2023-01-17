package com.myresto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myresto.dao.IProduitDao;
import com.myresto.domaine.Produit;

@Service("ProduitService")
public class ProduitService {
	
	@Autowired
	private IProduitDao iProduitDao;
	
	public ProduitService() {
	}

	public ProduitService(IProduitDao iProduitDao) {
		super();
		this.iProduitDao = iProduitDao;
	}
	
	public List<Produit> getAllProducts(){
		return iProduitDao.getAllProducts();
	}
	
	public void createProduit(Produit p) {
		iProduitDao.createProduit(p);
	}
	public void updateProduit(Produit p) {
		iProduitDao.updateProduit(p);
	}
	public void deleteProduit(int id) {
		iProduitDao.deleteProduit(id);
	}
	

}
