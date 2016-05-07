package vues;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import controleurs.ControleurAuthentification;
import controleurs.ControleurTabPraticiens;
import modeles.ModeleTabPraticiens;

public class VuePraticiens extends JPanel {

	private JRadioButton coefConfiance ;
	private JRadioButton coefNotoriete ;
	private JRadioButton tempsEcoule ;
	private JTable tabPraticiens ;
	
	private ModeleTabPraticiens modele ;
	private ControleurTabPraticiens controleur ;
	
	public VuePraticiens() {		
		super() ;
		System.out.println("VuePraticiens::VuePraticiens()") ;
		this.creerInterfaceUtilisateur() ;
		this.controleur = new ControleurTabPraticiens(this) ;
	}
		
	public void creerInterfaceUtilisateur() {		
		
		System.out.println("VuePraticiens::creerInterfaceUtilisateur()") ;
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxBoutons = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		
		coefConfiance = new JRadioButton("Coefficient de confiance ") ;
		coefNotoriete = new JRadioButton("Coefficient de notoriété ") ;
		tempsEcoule = new JRadioButton("Temps écoulé depuis la dernière visite ") ;
		ButtonGroup groupe = new ButtonGroup() ;
		coefNotoriete.setSelected(true);
		groupe.add(coefNotoriete) ;
		groupe.add(coefConfiance) ;
		groupe.add(tempsEcoule) ;
		boxBoutons.setBorder(new TitledBorder("Choix du critère de selection")) ;
		
		boxBoutons.add(coefNotoriete) ;
		boxBoutons.add(coefConfiance) ;
		boxBoutons.add(tempsEcoule) ;

		JLabel label = new JLabel("Resultat de la recherche");
		boxEtiquette.add(label);
		
		if(coefNotoriete.isSelected()) {
			modele = new ModeleTabPraticiens(1) ;
			this.tabPraticiens = new JTable(modele) ;
		}
		else if(coefConfiance.isSelected()) {
			modele = new ModeleTabPraticiens(2) ;
			this.tabPraticiens = new JTable(modele) ;
		}
		else if(tempsEcoule.isSelected()) {
			modele = new ModeleTabPraticiens(3) ;
			this.tabPraticiens = new JTable(modele) ;
		}
			
		
		this.tabPraticiens.setRowHeight(20) ;
		
		JScrollPane spPraticiens = new JScrollPane(this.tabPraticiens) ;
		spPraticiens.setPreferredSize(new Dimension(900,300)) ;

		boxTableau.add(spPraticiens) ;
		
		boxPrincipale.add(boxBoutons) ;
		boxPrincipale.add(Box.createVerticalStrut(20)) ;
		boxPrincipale.add(boxEtiquette);
		boxPrincipale.add(Box.createVerticalStrut(30)) ;
		boxPrincipale.add(boxTableau) ;		
		boxPrincipale.add(Box.createVerticalStrut(80)) ;
		this.add(boxPrincipale) ;
		this.setSize(new Dimension(950,400));
		this.setVisible(true) ;

		this.modele.actualiser() ;

	}

	public JRadioButton getbCoefConfiance() {
		return coefConfiance;
	}

	public JRadioButton getbCoefNotoriete() {
		return coefNotoriete;
	}

	public JRadioButton getbTempsEcoule() {
		return tempsEcoule;
	}

	public JTable getTabPraticiens() {
		return tabPraticiens;
	}

	public void setTabPraticiens(JTable tabPraticiens) {
		this.tabPraticiens = tabPraticiens;
	}
	
	
	
}
