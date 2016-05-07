package modeles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.* ;

public class ModeleListePraticiens {

	private static final long serialVersionUID = 1L;
	
	private Connection connexion = null;
	private Statement stmt;
	private static ModeleListePraticiens modele = null;	
	private List<Praticien> praticiens = new ArrayList<Praticien>() ;
	
	public ModeleListePraticiens() {
		super() ;
		System.out.println("ModeleListePraticiens::ModeleListePraticiens()") ;
		connexion = ModeleBdd.connexion();
		try {
			stmt = connexion.createStatement();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static  ModeleListePraticiens getModele(){
		System.out.println("ModeleListePraticiens::getModele()") ;
		if(modele == null){
			modele = new ModeleListePraticiens() ;
		}
		return modele ;
	}
	
	public List<Praticien> getTab(int parametre) {
		System.out.println("ModeleListePraticiens::peupler()") ;
		ResultSet rs ;
		if(parametre == 1) {
			
			try {
				rs = stmt.executeQuery("SELECT PRA_NUM, PRA_NOM, PRA_PRENOM, PRA_COEFNOTORIETE FROM PRATICIEN "
						+ "ORDER BY(PRA_COEFNOTORIETE) desc;") ;
				if(! praticiens.isEmpty()){
					praticiens = new ArrayList<Praticien>() ;
				}				
				while (rs.next()) {
					Praticien praticien = new Praticien() ;
					praticien.setPra_num(rs.getInt("PRA_NUM")) ;
					praticien.setPra_nom(rs.getString("PRA_NOM")) ;						
					praticien.setPra_prenom(rs.getString("PRA_PRENOM")) ;
					praticien.setPra_coefnotoriete(rs.getFloat("PRA_COEFNOTORIETE"));
					praticiens.add(praticien) ;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}				
		}
		else if(parametre == 2){
			try {
				rs = stmt.executeQuery("SELECT PRATICIEN.PRA_NUM, PRA_NOM, PRA_PRENOM, RAP_COEFF_CONFIANCE "
						+ "FROM PRATICIEN INNER JOIN RAPPORT_VISITE "
						+ "ON PRATICIEN.PRA_NUM = RAPPORT_VISITE.PRA_NUM "
						+ "WHERE RAP_DATE_VISITE IN (SELECT MAX(RAP_DATE_VISITE) "
							+ "FROM RAPPORT_VISITE GROUP BY(PRA_NUM)) "
						+ "ORDER BY(RAP_COEFF_CONFIANCE)") ;
				
				if(! praticiens.isEmpty()){
					praticiens = new ArrayList<Praticien>() ;
				}	
				while (rs.next()) {
					Praticien praticien = new Praticien() ;
					praticien.setPra_num(rs.getInt("PRA_NUM")) ;
					praticien.setPra_nom(rs.getString("PRA_NOM")) ;						
					praticien.setPra_prenom(rs.getString("PRA_PRENOM")) ;
					praticien.setPra_coefconfiance(rs.getFloat("RAP_COEFF_CONFIANCE"));
					praticiens.add(praticien) ;
				}
			} catch(SQLException e) {
				
			}
		}
		else if(parametre == 3) {
			try{
				rs = stmt.executeQuery("SELECT PRATICIEN.PRA_NUM, PRA_NOM, PRA_PRENOM, RAP_COEFF_CONFIANCE, RAP_DATE_VISITE "
						+ "FROM PRATICIEN INNER JOIN RAPPORT_VISITE "
						+ "ON PRATICIEN.PRA_NUM = RAPPORT_VISITE.PRA_NUM "
						+ "WHERE RAP_DATE_VISITE IN (SELECT MAX(RAP_DATE_VISITE) "
							+ "FROM RAPPORT_VISITE "
							+ "GROUP BY(PRA_NUM)) ;") ;
				if(! praticiens.isEmpty()){
					praticiens = new ArrayList<Praticien>() ;
				}
				while (rs.next()) {
					Praticien praticien = new Praticien() ;
					praticien.setPra_num(rs.getInt("PRA_NUM")) ;
					praticien.setPra_nom(rs.getString("PRA_NOM")) ;						
					praticien.setPra_prenom(rs.getString("PRA_PRENOM")) ;
					praticien.setPra_tempsecoule(rs.getDate("RAP_DATE_VISITE"));
					praticiens.add(praticien) ;
				}
				
			} catch(SQLException e) {
				
			}
		}
		return praticiens;
	}

}
