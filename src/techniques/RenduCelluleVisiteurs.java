package techniques;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import modeles.ModeleTabVisiteurs;
import modeles.Visiteur;

public class RenduCelluleVisiteurs extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	public RenduCelluleVisiteurs(){
		super() ;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		
		DefaultTableCellRenderer composant = (DefaultTableCellRenderer) super.getTableCellRendererComponent(table, value, isSelected, hasFocus,	row, column);
		Visiteur visiteur = ((ModeleTabVisiteurs) table.getModel()).getVisiteur(row) ;
		
		if(column == 1 || column == 2) {
			composant.setHorizontalAlignment(CENTER);
		}
		
		return composant ;
	}
	
	
}