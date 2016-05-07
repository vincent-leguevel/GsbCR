package modeles;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModeleTabPraticiens extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private String[] entetes1 = {"Numero","Nom","Prenom","Coefficient notoriété"};
	private String[] entetes2 = {"Numero","Nom","Prenom","Coefficient de confiance"} ;
	private String[] entetes3 = {"Numero","Nom","Prenom","Date de dernière visite"} ;
	private List<Praticien> tabPraticiens = new ArrayList<Praticien>() ;
	private int typeModele ;

	public ModeleTabPraticiens(int typeModele) {
		super() ;
		System.out.println("ModeleTabPraticiens::ModeleTabPraticiens()") ;
		this.typeModele = typeModele ;
		this.tabPraticiens = ModeleListePraticiens.getModele().getTab(this.typeModele);
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		System.out.println("ModeleTabPraticiens::getColumnName()") ;
		switch (this.typeModele) {
			case 1 :
				return this.entetes1[columnIndex] ;
			case 2 :
				return this.entetes2[columnIndex] ;
			case 3 :
				return this.entetes3[columnIndex] ;
			default :
				return null ;	
		}
	}

	@Override
	public int getColumnCount() {
		System.out.println("ModeleTabPraticiens::getColumnCount()") ;
		switch (this.typeModele) {
		case 1 :
			return this.entetes1.length ;
		case 2 :
			return this.entetes2.length ;
		case 3 :
			return this.entetes3.length ;
		default :
			return 0 ;
		}
		
	}

	@Override
	public int getRowCount() {
		System.out.println("ModeleTabPraticiens::getRowCount()") ;
		return this.tabPraticiens.size() ;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {		
		System.out.println("ModeleTabPraticiens::getValueAt()");
		switch(columnIndex) {		
			case 0 :
				return new Integer(this.tabPraticiens.get(rowIndex).getPra_num()) ;
			case 1 : 
				return this.tabPraticiens.get(rowIndex).getPra_nom() ;
			case 2 : 
				return this.tabPraticiens.get(rowIndex).getPra_prenom() ;
			case 3 : 
				if(this.typeModele == 1) {
					return new Float(this.tabPraticiens.get(rowIndex).getPra_coefnotoriete()) ;
				}
				else if(this.typeModele == 2) {
					return new Float(this.tabPraticiens.get(rowIndex).getPra_coefconfiance()) ;
				}
				else if(this.typeModele == 3) {
					return this.tabPraticiens.get(rowIndex).getPra_tempsecoule() ;
				}
			default : 
				return null ;
		}
	}
	
	public void actualiser(){
		System.out.println("ModeleTabPraticiens::actualiser()") ;
		this.fireTableDataChanged();
	}

	public int getTypeModele() {
		return typeModele;
	}

	public void setTypeModele(int typeModele) {
		this.typeModele = typeModele;
	}
	
		
}
