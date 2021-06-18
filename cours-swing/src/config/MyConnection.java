package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	private static String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false&serverTimezone=UTC";
	private static String utilisateur = "root";
	private static String motDePasse = "root";
	private static Connection connexion = null;
	
	private MyConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// constructeur privé donc créer une méthode pour obtenir, 
	// si trop d'utilisateur utilisent le meme constructeur, 
	// on crée objet pour appeler le meme constructor pour économiser les memoires
	// donc une convention avec le disign 'pattern' pour le metier
	public static Connection getConnection() { 
		if (connexion == null) {
			new MyConnection();
		}
		return connexion;
	}
}
