package techniques;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import controleurs.ControleurBoutonCR;
import vues.VueVisiteurs;

public class EditeurBoutonCR extends DefaultCellEditor {

	protected JButton bEnregistrer ;
	private boolean isPushed ;
	private static JCheckBox checkBox = new JCheckBox() ;
	private ControleurBoutonCR controleur;
	private VueVisiteurs vueVisiteur ;
	
	public EditeurBoutonCR(VueVisiteurs vueVisiteur) {
		super(checkBox) ;
		this.vueVisiteur = vueVisiteur;
		System.out.println(this.vueVisiteur.test);
		this.controleur = new ControleurBoutonCR(this); 
		bEnregistrer = new JButton() ;
		this.bEnregistrer.addActionListener(controleur) ;
		
		//this.controleur.setEditeurBoutonCR(this) ;
	}	
	
	public VueVisiteurs getVueVisiteur() {
		return vueVisiteur;
	}

	public JButton getbEnregistrer() {
		return bEnregistrer ;
	}

	public void setbEnregistrer(JButton bEnregistrer) {
		this.bEnregistrer = bEnregistrer;
	}

	public boolean isPushed() {
		return isPushed;
	}

	public void setPushed(boolean isPushed) {
		this.isPushed = isPushed;
	}

	public ControleurBoutonCR getControleur() {
		return controleur;
	}

	public void setControleur(ControleurBoutonCR controleur) {
		this.controleur = controleur;
	}

	public Component getTableCellEditorComponent(JTable table, Object object, boolean isPushed, int row, int column) {
		
		controleur.setRow(row) ;
		controleur.setColumn(column) ;
		controleur.setTable(table) ;
		
		bEnregistrer.setText("Consulter un rapport") ;
			
		return bEnregistrer;
		
	}
	
}
