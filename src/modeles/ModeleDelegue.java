package modeles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeleDelegue {

	private Connection connexion = null;
	private Statement stmt;
	private Delegue delegue;
	
	public ModeleDelegue(){
		connexion = ModeleBdd.connexion();
		
		try {
			stmt = connexion.createStatement();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Delegue connexionDelegue(String nom, String mdp) {
		System.out.println("Delegue::connexionVisiteur()") ;
		ResultSet rs;
		try {
			rs = stmt.executeQuery("SELECT VISITEUR.vis_matricule, vis_nom, vis_prenom,reg_code "
					+ "FROM VISITEUR INNER JOIN TRAVAILLER "
					+ "ON TRAVAILLER.VIS_MATRICULE = VISITEUR.VIS_MATRICULE "
					+ "WHERE VISITEUR.VIS_NOM = '"+ nom +"' AND (TRA_ROLE = 'Délégué' OR TRA_ROLE = 'Responsable') "
					+ "AND JJMMAA = (SELECT MAX(JJMMAA) "
					+ "FROM TRAVAILLER AS t "
					+ "WHERE t.VIS_MATRICULE = TRAVAILLER.VIS_MATRICULE) "
					+ "AND VIS_MDP = '"+ mdp +"';");
			
			System.out.println("VisiteurBDD::connexionVisiteur()") ;			
			while(rs.next()){				
				delegue = new Delegue(rs.getString("vis_matricule"),rs.getString("vis_nom"),rs.getString("vis_prenom"),rs.getString("reg_code"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delegue;
		
	}
}
