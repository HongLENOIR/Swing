package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.MyConnection;
import model.Personne;

public class PersonnelDao {
	
	// toutes les infos dans ce tableau de Personne
	public ArrayList<Personne>findAll(){ 
		ArrayList<Personne> personnes = null;
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				personnes = new ArrayList<>();
				PreparedStatement ps = c.prepareStatement("select * from personne");
				ResultSet r = ps.executeQuery();
				while (r.next()) {
					Personne personne = new Personne(r.getInt("num"), r.getString("nom"), r.getString("prenom"));
					personnes.add(personne);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return personnes;
	}
	
	// trouver la ligne par id
	public Personne findById(int id) {
		Personne personne = null;
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from personne where num = ?; ");
				ps.setInt(1, id);
				ResultSet r = ps.executeQuery();
				if (r.next())
					personne = new Personne(r.getInt("num"), r.getString("nom"), r.getString("prenom"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return personne;
	}
	
	// 'Insert'
	public Personne save(Personne personne) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
		try {
		c.setAutoCommit(false);
		PreparedStatement ps = c.prepareStatement("insert into personne (nom,prenom) values (?,?); ", PreparedStatement.
		RETURN_GENERATED_KEYS);
		ps.setString(1, personne.getNom());
		ps.setString(2, personne.getPrenom());
		ps.executeUpdate();
		ResultSet resultat = ps.getGeneratedKeys();
		if (resultat.next()) {
		c.commit();
		personne.setNum(resultat.getInt(1));
		return personne;
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
		return null;
		}

	// 'update' 
	public Personne update(Personne personne) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
		try {
		c.setAutoCommit(false);
		PreparedStatement ps = c.prepareStatement("update personne set nom=?, prenom= ? where num=?; ", PreparedStatement.
		RETURN_GENERATED_KEYS);
		ps.setString(1, personne.getNom());
		ps.setString(2, personne.getPrenom());
		ps.setInt(3,  3);
		ps.executeUpdate();
		ResultSet resultat = ps.getGeneratedKeys();
		if (resultat.next()) {
		c.commit();
		personne.setNum(resultat.getInt(1));
		return personne;
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
		return null;
	}
	
	// 'Remove'
	
	
	
}
	