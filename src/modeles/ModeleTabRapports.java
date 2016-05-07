package modeles;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModeleTabRapports extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	
	private String[] entetes = {"Matricule","Numéro Rapport","Numero Praticien", "Bilan","Date de visite",
			"Coefficient de confiance","Date de rédaction","Motif"} ;
	private List<Rapport> tabRapports = new ArrayList<Rapport>() ;

	public ModeleTabRapports(String matricule, int mois, int annee) {
		super() ;
		System.out.println("ModeleTabVisiteurs::ModeleTabVisiteurs()") ;
		this.tabRapports = ModeleListeRapports.getModele().getTab(matricule, mois, annee);
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		System.out.println("ModeleTabVisiteurs::getColumnName()") ;
		return this.entetes[columnIndex] ;
	}
	
	@Override
	public int getColumnCount() {
		System.out.println("ModeleTabVisiteurs::getColumnCount()") ;
		return this.entetes.length ;
	}

	@Override
	public int getRowCount() {
		System.out.println("ModeleTabVisiteurs::getRowCount()") ;
		return this.tabRapports.size() ;
	}
	
	public Class getColumnClass(int columnIndex) {
		switch(columnIndex)
		{
		case 0:
			return String.class ;
		case 1:
			return Integer.class ;
		case 2: 
			return Integer.class ;
		case 3:
			return String.class ;
		case 4:
			return String.class ;
		case 5:
			return Integer.class ;
		case 6:
			return String.class ;
		case 7:
			return String.class ;
		default:
			return Object.class ;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0:
				return this.tabRapports.get(rowIndex).getVis_matricule() ;
			case 1:
				return this.tabRapports.get(rowIndex).getRap_num() ;
			case 2:
				return this.tabRapports.get(rowIndex).getPra_num() ;
			case 3:
				return this.tabRapports.get(rowIndex).getRap_bilan() ;
			case 4:
				return this.tabRapports.get(rowIndex).getRap_date_visite() ;
			case 5:
				return this.tabRapports.get(rowIndex).getRap_coeff_confiance() ;
			case 6:
				return this.tabRapports.get(rowIndex).getRap_date_redaction() ;
			case 7:
				return this.tabRapports.get(rowIndex).getRap_motif() ;
			default:
				return null;
		}
		
	}
	
	public void actualiser(){
		System.out.println("ModeleTabRapports::actualiser()") ;
		this.fireTableDataChanged();
	}
	
	public Rapport getRapport(int indiceLigne) {
		return this.tabRapports.get(indiceLigne) ;
	}

}
