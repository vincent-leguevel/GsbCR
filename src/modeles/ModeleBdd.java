package modeles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ModeleBdd {

	private static Connection connexion = null;
	private String url = "jdbc:mysql://localhost:3306/GsbCRSlam";
	private String user = "root";
	private String mdp = "mysql";
	
	private ModeleBdd(){
		System.out.println("ConnectionBDD::ConnectionBDD");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Chargement du driver réussi !");
			
			connexion = DriverManager.getConnection(url,user,mdp);
			
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Une erreur est survenue","Erreur",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public static Connection connexion(){
		System.out.println("ConnectionBDD::connexion");
		
		if(connexion == null){
			new ModeleBdd();
		}
		
		return connexion;
	}
}
