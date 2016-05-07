package vues;

import java.awt.Component;
import java.awt.Container;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VueAPropos extends JDialog {

	private static final long serialVersionUID = 1L;

	public VueAPropos() {
		super() ;
		System.out.println("VueAPropos::VueAPropos()") ;
		this.creerInterfaceUtilisateur() ;
	}
		
	public void creerInterfaceUtilisateur() {
		System.out.println("VueAPropos::creerInterfaceUtilisateur") ;
		
		Container conteneur = this.getContentPane() ;
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxImage = Box.createVerticalBox() ;
		Box boxTexte = Box.createVerticalBox() ;
		
		JLabel logo = new JLabel(new ImageIcon("/home/vincent/Téléchargements/gsb2.png")) ;
		boxImage.add(logo) ;
		
		JLabel texte = new JLabel("GSB 2015 - 2016 v2") ;
		
		boxTexte.add(texte) ;
		JLabel nom = new JLabel("Aurélien ALVES");
		JLabel nom1 = new JLabel("Vincent LE GUEVEL") ;
		boxTexte.add(Box.createVerticalStrut(20)) ;
		boxTexte.add(nom1) ;
		boxTexte.add(Box.createVerticalStrut(5)) ;
		boxTexte.add(nom) ;
		
		boxPrincipale.add(boxImage) ;
		boxPrincipale.add(Box.createVerticalStrut(10)) ;
		boxPrincipale.add(boxTexte) ;
		
		conteneur.add(boxPrincipale) ;
		this.setTitle("A Propos") ;
		
		this.setSize(200,200) ; 
		this.pack();
		this.setLocationRelativeTo(null) ;
		this.setVisible(true) ;
		this.setResizable(false);
	}
	
	public static void main(String[] args) {
		new VueAPropos() ;
	}
	
}
