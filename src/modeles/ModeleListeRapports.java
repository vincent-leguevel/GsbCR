package modeles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModeleListeRapports {

	private Connection connexion = null;
	private PreparedStatement pstmt;
	private List<Rapport> rapports = new ArrayList<Rapport>();
	private static ModeleListeRapports modele = null;
	
	public ModeleListeRapports() {
		super() ;
		System.out.println("ModeleListeRapports::ModeleListeRapports()") ;
		connexion = ModeleBdd.connexion();
	}
	
	public static  ModeleListeRapports getModele(){
		System.out.println("ModeleListeRapports::getModele()") ;
		if(modele == null){
			modele = new ModeleListeRapports() ;
		}
		return modele ;
	}
	
	public List<Rapport> getTab(String matricule, int mois , int annee){
		System.out.println("ModeleListeRapports::getTab()") ;
		
		try{
			pstmt = connexion.prepareStatement("SELECT * FROM RAPPORT_VISITE WHERE RAP_DATE_REDACTION LIKE ? AND VIS_MATRICULE = ? ;");
            pstmt.setString(1, annee+"-"+0+mois+"%");
            pstmt.setString(2, matricule);
			ResultSet rs = pstmt.executeQuery();
			if(! rapports.isEmpty()){
				rapports = new ArrayList<Rapport>() ;
			}	
			while (rs.next()) {
				Rapport rapport = new Rapport() ;
				rapport.setVis_matricule(rs.getString("VIS_MATRICULE"));
				rapport.setRap_num(rs.getInt("RAP_NUM"));
				rapport.setPra_num(rs.getInt("PRA_NUM"));
				rapport.setRap_bilan(rs.getString("RAP_BILAN"));
				rapport.setRap_date_visite(rs.getString("RAP_DATE_VISITE"));
				rapport.setRap_coeff_confiance(rs.getInt("RAP_COEFF_CONFIANCE"));
				rapport.setRap_date_redaction(rs.getString("RAP_DATE_REDACTION"));
				rapport.setRap_motif(rs.getString("RAP_MOTIF"));
				rapports.add(rapport);
			}
			
		} catch(SQLException e) {
			e.getMessage();
		}
		return rapports;
		
	}
}
