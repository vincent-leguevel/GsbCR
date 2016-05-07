package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import techniques.EditeurBoutonCR;
import vues.VueDateRapport;
import vues.VueGsb;

public class ControleurBoutonCR implements ActionListener {

	private int row ;
	private int column ;
	private JTable table ;
	private EditeurBoutonCR editeur ;
	private VueGsb vue;
	
	public ControleurBoutonCR(EditeurBoutonCR editeur) {
		super() ;
		System.out.println("ControleurBoutonCR::ControleurBoutonCR()") ;
		this.editeur = editeur;
		System.out.println("- - - - - - - - - - - - - - - - - - - - -") ;
		System.out.println(this.editeur.getVueVisiteur().getVueGsb().getTitle()) ;
		System.out.println("- - - - - - - - - - - - - - - - - - - - -") ;
		
	}	
	
	public EditeurBoutonCR getEditeurBoutonCR() {
		return editeur;
	}

	public void setEditeurBoutonCR(EditeurBoutonCR editeurBoutonCR) {
		this.editeur = editeurBoutonCR;
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurBoutonCR::actionPerformed()") ;
		Object sourceEvt = e.getSource() ;
		if(sourceEvt == this.editeur.getbEnregistrer()) {
			String matricule = (String) this.getTable().getValueAt(this.getRow(), 0);
			System.out.println(matricule);
			new VueDateRapport(this.editeur.getVueVisiteur().getVueGsb(), matricule) ;
		}
	}

}
