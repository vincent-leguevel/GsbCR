package modeles;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

public class ModeleTabVisiteurs extends AbstractTableModel {

	private String[] entetes = {"Matricule","Nom","Prenom", "Compte-rendu"} ;
	private List<Visiteur> tabVisiteurs = new ArrayList<Visiteur>() ;
	
	public ModeleTabVisiteurs(Delegue delegue) {
		super() ;
		System.out.println("ModeleTabVisiteurs::ModeleTabVisiteurs()") ;
		this.tabVisiteurs = ModeleListeVisiteurs.getModele().getTab(delegue);
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
		return this.tabVisiteurs.size() ;
	}
	
	public Class getColumnClass(int columnIndex) {
		switch(columnIndex)
		{
		case 0:
			return String.class ;
		case 1:
			return String.class ;
		case 2: 
			return String.class ;
		case 3:
			return JButton.class ;
		default:
			return Object.class ;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		System.out.println("ModeleTabVisiteurs::getValueAt()") ;
		switch(columnIndex) {
			case 0 :
				return this.tabVisiteurs.get(rowIndex).getVis_matricule() ;
			case 1 :
				return this.tabVisiteurs.get(rowIndex).getVis_nom() ;
			case 2 :
				return this.tabVisiteurs.get(rowIndex).getVis_prenom() ;
			default :
				return null ;
		}
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		System.out.println("ModeleTabVisiteurs::isCellEditable("+rowIndex+","+columnIndex+")") ;
		if(columnIndex == 3) {
			return true ;
		}
		else{
			return false ;
		}
		
	}
	
	public void actualiser(){
		System.out.println("ModeleTabVisiteurs::actualiser()") ;
		this.fireTableDataChanged();
	}
	
	public Visiteur getVisiteur(int indiceLigne) {
		return this.tabVisiteurs.get(indiceLigne) ;
	}
	
}
