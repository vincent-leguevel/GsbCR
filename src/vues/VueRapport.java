package vues;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modeles.ModeleTabRapports;

public class VueRapport extends JPanel {

	private ModeleTabRapports modele ;
	private JTable tabRapports ;
	private String matricule ;
	private int mois ;
	private int annee ;
	
	public VueRapport(String matricule, int mois, int annee) {
		super() ;
		System.out.println("VueRapport::VueRapport(String matricule, int mois, int annee)") ;
		this.matricule = matricule ;
		this.mois = mois ;
		this.annee = annee ;
		this.creerInterfaceUtilisateur();
	}
	
	public void creerInterfaceUtilisateur() {
		JLabel label = new JLabel("Liste des rapports du visiteur :") ;
		
		System.out.println("VueVisiteurs::creerInterfaceUtilisateur()") ;
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;
		
		modele = new ModeleTabRapports(this.matricule, this.mois, this.annee) ;
		this.tabRapports = new JTable(modele) ;
		this.tabRapports.setRowHeight(20);
		JScrollPane spVisiteur = new JScrollPane(this.tabRapports) ;
		spVisiteur.setPreferredSize(new Dimension(900,300)) ;		
		
		this.add(label) ;
		this.add(Box.createVerticalStrut(10)) ;
		boxTableau.add(spVisiteur) ;
		
		boxPrincipale.add(boxTableau) ;		
		boxPrincipale.add(Box.createVerticalStrut(80)) ;
		this.add(boxPrincipale) ;
		this.setSize(new Dimension(950,400));
		this.setVisible(true) ;

		this.modele.actualiser() ;
	}
	
}
