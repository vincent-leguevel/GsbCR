package techniques;

import java.awt.Component;

import javax.swing.JButton ;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import modeles.ModeleTabVisiteurs;
import modeles.Visiteur;

public class RenduBoutonCR extends JButton implements TableCellRenderer {

private static final long serialVersionUID = 1L;
	
	public RenduBoutonCR(){
		super() ;
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		Visiteur visiteur = ((ModeleTabVisiteurs) table.getModel()).getVisiteur(row) ;
		
		this.setText("Consulter un rapport");
		
		if(column == 3) {
			this.setEnabled(true) ;
			return this ;
		}
		return null ;
		
	}
	
}
