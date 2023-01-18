package com.myresto.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myresto.domaine.Commande;
import com.myresto.domaine.Produit;

@Repository
public class ProduitDao implements IProduitDao{

	private JdbcTemplate jdbcTemplate;
	
	public ProduitDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	//READ
		@Override
	public Produit getProduitById(int id ) {
		Object[] arguments = new Object[1];
		arguments[0]= id;
		return (Produit) jdbcTemplate.query("Select * from from myresto.produit where id =?", (resultSet, RowNum) ->{
			return new Produit(resultSet.getInt("id"),resultSet.getInt("id"),resultSet.getString("libelle"),resultSet.getDouble("prix"));
		});
	}

	//Read
	public List<Produit> getAllProducts(){
		return jdbcTemplate.query("Select * from myresto.produit",(resultSet, rowNum) -> {
			return new Produit(resultSet.getInt("id"),resultSet.getInt("id"),resultSet.getString("libelle"),resultSet.getDouble("prix"));
		});
	}
	//CREATE
	public void createProduit(Produit p) {
		Object[] arguments = new Object[3];
		arguments[0] = p.getidType();
		arguments[1] = p.getLibelle();
		arguments[2] = p.getPrix();
		jdbcTemplate.update("INSERT INTO myresto.produit(id_type,libelle,prix) VALUES(?,?,?)",arguments);
	}
	//UPDATE
	public void updateProduit(Produit p) {
		Object[] arguments = new Object[4];
		arguments[0] = p.getidType();
		arguments[1] = p.getLibelle();
		arguments[2] = p.getPrix();
		arguments[3] = p.getId();
		jdbcTemplate.update("UPDATE myresto.produit (id_type,libelle,prix) SET(?,?,?) where myresto.produit= ?",arguments);
	}
	
	//DELETE
	public void deleteProduit(int id) {
		jdbcTemplate.execute("DELETE FROM myresto.produit where produit.id="+id);
	}
}
