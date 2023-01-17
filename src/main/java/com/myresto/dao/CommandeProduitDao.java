package com.myresto.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myresto.domaine.Commande;
import com.myresto.domaine.CommandeProduit;
import com.myresto.domaine.Produit;
@Repository
public class CommandeProduitDao implements ICommandeProduitDao {

private JdbcTemplate jdbcTemplate;
private CommandeDao commandeDao;
private ProduitDao produitDao;
	public CommandeProduitDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate =jdbcTemplate;
	}
	//read
	@Override
	public List<CommandeProduit> getAllCommandeProduit() {
		return jdbcTemplate.query("Select * from commandeProduit", (resultSet, rowNum)->{
			CommandeProduit cp = new CommandeProduit(resultSet.getInt("id"),resultSet.getInt("idCommande"),resultSet.getInt("idProduit"),resultSet.getInt("qte"),resultSet.getBoolean("menu"));
			Commande cmd = commandeDao.getCommandeById(resultSet.getInt("idCommande"));
			Produit pr = produitDao.getProduitById(resultSet.getInt("idProduit"));
			List<Produit> listProduit = new ArrayList<Produit>();
			listProduit.add(pr);
			cp.setProduits(listProduit);
			cp.setCommandes(cmd);
			return cp;
		});
	}
	//create
	@Override
	public void createCommandeProduit(CommandeProduit cp) {
		Object[] arguments = new Object[4];
		arguments[0] = cp.getIdCommande();
		arguments[1] = cp.getIdProduit();
		arguments[2] = cp.getQte();
		arguments[3] = cp.isMenu();
		jdbcTemplate.update("INSERT INTO myresto.commandeProduit(idCommande,idProduit,qte,menu) VALUES(?,?,?,?)",arguments);
	}
	//update
	@Override
	public void updateCommandeProduit(CommandeProduit cp) {
		Object[] arguments = new Object[4];
		arguments[0] = cp.getIdCommande();
		arguments[1] = cp.getIdProduit();
		arguments[2] = cp.getQte();
		arguments[3] = cp.isMenu();
		arguments[3] = cp.getId();
		jdbcTemplate.update("UPDATE myresto.commandeProduit (idCommande,idProduit,qte,menu) SET(?,?,?,?) where myresto.commandeProduit= ?",arguments);
		
	}
	//delete
	@Override
	public void deleteCommandeProduit(int id) {
		jdbcTemplate.execute("DELETE FROM myresto.commandeProduit where commandeProduit.id="+id);
		
	}

	
}
