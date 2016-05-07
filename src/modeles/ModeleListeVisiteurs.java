package modeles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.* ;

public class ModeleListeVisiteurs {

	private static final long serialVersionUID = 1L;
	
	private Connection connexion = null ;
	private Statement stmt ;
	private static ModeleListeVisiteurs modele = null ;
	private List<Visiteur> visiteurs = new ArrayList<Visiteur>() ;
	
	public ModeleListeVisiteurs() {
		super() ;
		System.out.println("ModeleListeVisiteurs::ModeleListeVisiteurs()") ;
		connexion = ModeleBdd.connexion();
		try {
			stmt = connexion.createStatement();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static  ModeleListeVisiteurs getModele(){
		System.out.println("ModeleListeVisiteurs::getModele()") ;
		if(modele == null){
			modele = new ModeleListeVisiteurs() ;
		}
		return modele ;
	}
	
	public List<Visiteur> getTab(Delegue delegue) {
		System.out.println("ModeleListeVisiteurs::peupler()") ;
		visiteurs.clear() ;
		ResultSet rs ;
		String regCode = delegue.getReg_code() ;
		System.out.println(regCode) ;
		try {
			String sql = "SELECT VISITEUR.vis_matricule, vis_nom, vis_prenom,reg_code "
					+ "FROM VISITEUR INNER JOIN TRAVAILLER "
					+ "ON TRAVAILLER.VIS_MATRICULE = VISITEUR.VIS_MATRICULE "
					+ "WHERE REG_CODE = ? "
					+ "AND (TRA_ROLE = 'Visiteur') "
					+ "AND JJMMAA = (SELECT MAX(JJMMAA) "
						+ "FROM TRAVAILLER AS t "
						+ "WHERE t.VIS_MATRICULE = TRAVAILLER.VIS_MATRICULE) ;" ;
			PreparedStatement pstmt = connexion.prepareStatement(sql) ;
			pstmt.setString(1, regCode);
			rs = pstmt.executeQuery() ;
			
			while (rs.next()) {
				Visiteur visiteur = new Visiteur() ;
				visiteur.setVis_matricule(rs.getString("vis_matricule")) ;
				visiteur.setVis_nom(rs.getString("vis_nom")) ;
				visiteur.setVis_prenom(rs.getString("vis_prenom")) ; 
				visiteur.setReg_code(rs.getString("reg_code")) ;
				visiteurs.add(visiteur) ;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return visiteurs ;
		
	}	
}
