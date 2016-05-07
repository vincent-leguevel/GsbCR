package vues;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueAccueil extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel accueil = new JLabel(new ImageIcon("/home/vincent/Téléchargements/gsb2.png")) ;
	
	public VueAccueil() {
		super() ;
		System.out.println("VueAccueil::VueAccueil()") ;
		this.creerInterfaceUtilisateur() ;
	}
	
	public void creerInterfaceUtilisateur() {
		
		System.out.println("VueAccueil::creerInterfaceUtilisateur()") ;
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		
		
		boxEtiquette.add(accueil) ;
		boxPrincipale.add(Box.createVerticalStrut(80)) ;
		boxPrincipale.add(boxEtiquette) ;		
		boxPrincipale.add(Box.createVerticalStrut(80)) ;
		this.add(boxPrincipale) ;
		this.setSize(new Dimension(950,450));
		this.setVisible(true) ;
		
	}
	
}