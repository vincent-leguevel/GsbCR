package vues;

import java.awt.Container;
import java.awt.Dimension;
import java.util.List;

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
import modeles.Delegue;
import modeles.ModeleTabPraticiens;
import modeles.ModeleTabVisiteurs;
import modeles.Visiteur;
import techniques.EditeurBoutonCR;
import techniques.RenduBoutonCR;
import techniques.RenduCelluleVisiteurs;

public class VueVisiteurs extends JPanel {
	
	private ModeleTabVisiteurs modele ;	
	private JTable tabVisiteurs ;
	private RenduBoutonCR renduBoutonCR = new RenduBoutonCR() ;
	private Delegue delegue ;
	private RenduCelluleVisiteurs renduVisiteurs = new RenduCelluleVisiteurs() ;
	private VueGsb vueGsb;
	public String test = "test";
	private EditeurBoutonCR editeurBoutonCR;
	
	public VueVisiteurs(Delegue delegue, VueGsb vueGsb){
		super() ;
		System.out.println("VueVisiteurs::VueVisiteurs()") ;
		this.delegue = delegue ;
		this.vueGsb = vueGsb;
		this.editeurBoutonCR  = new EditeurBoutonCR(this);
		this.creerInterfaceUtilisateur() ;		
	}
	
	public void creerInterfaceUtilisateur() {
		
		JLabel label = new JLabel("Liste des visiteurs :") ;
		
		System.out.println("VueVisiteurs::creerInterfaceUtilisateur()") ;
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;
		
		modele = new ModeleTabVisiteurs(this.delegue) ;
		this.tabVisiteurs = new JTable(modele) ;
		this.tabVisiteurs.setRowHeight(20);
		this.appliquerRendu() ;
		this.appliquerEditeur() ;
		JScrollPane spVisiteur = new JScrollPane(this.tabVisiteurs) ;
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
	
	public void appliquerRendu() {
		System.out.println("VueListeLocations::appliquerRendu()") ;
		this.tabVisiteurs.setDefaultRenderer(Object.class, renduVisiteurs);
		if(this.tabVisiteurs.getColumnClass(3) == JButton.class) {
			this.tabVisiteurs.setDefaultRenderer(JButton.class, renduBoutonCR);
		}
		
	}
	
	public void appliquerEditeur() {
		System.out.println("VueListeLocations::appliquerEditeur()") ;
		this.tabVisiteurs.setDefaultEditor(Object.class, editeurBoutonCR);
	}
	
	public JTable getTabVisiteurs() {
		return this.tabVisiteurs ;
	}

	public VueGsb getVueGsb() {
		// TODO Auto-generated method stub
		return this.vueGsb;
	}
	
}
