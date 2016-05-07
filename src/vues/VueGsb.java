package vues;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controleurs.ControleurGsb;
import modeles.Delegue;

import javax.swing.Box;


public class VueGsb extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ControleurGsb controleur ;
		
	private JMenuItem itemAccueil = new JMenuItem("Accueil") ;
	private JMenuItem itemDeconnecter  = new JMenuItem("Déconnexion") ;
	private JMenuItem itemQuitter = new JMenuItem("Quitter") ;
	private JMenuItem itemConsulterRapport = new JMenuItem("Consulter un rapport") ;
	private JMenuItem itemVisualiserPraticiens = new JMenuItem("Liste des praticiens hésitants") ;
	private JMenuItem itemAPropos = new JMenuItem("A propos") ;
	private JMenuItem itemAide = new JMenuItem("Aide") ;
	
	private JMenu menuFichier = new JMenu("Fichier") ;
	private JMenu menuRapports = new JMenu("Rapports") ;
	private JMenu menuPraticiens = new JMenu("Praticiens") ;
	private JMenu menuAide = new JMenu("Aide") ;
	private CardLayout clPanneaux = new CardLayout(5,5) ;
	private Container conteneur ;
	private VueAccueil vueAccueil = new VueAccueil() ;
	private VueVisiteurs vueVisiteurs ;
	private VuePraticiens vuePraticiens = new VuePraticiens() ;
	private VueRapport vueRapport;
	private Delegue delegue ;
	private Image icon = Toolkit.getDefaultToolkit().createImage("/home/vincent/Téléchargements/gsb2.png");
	
	public VueGsb(Delegue delegue) {
		super();
		System.out.println("VueGsb::VueGsb()") ;
		this.setIconImage(icon);
		this.setTitle("Appli-CR") ;		
		this.setSize(1000,500) ; 
		this.setLocationRelativeTo(null) ;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		this.delegue = delegue ;
		this.vueVisiteurs = new VueVisiteurs(delegue, this) ;
		
		this.creerBarreMenus() ;
		this.setMenusConnecte();
		this.setVisible(true) ;
		
		this.controleur = new ControleurGsb(this) ;
		
		
		conteneur = this.getContentPane() ;
		conteneur.setLayout(clPanneaux) ;		
		
		conteneur.add(vueAccueil, "Accueil");
		conteneur.add(vueVisiteurs, "Visiteurs") ;
		conteneur.add(vuePraticiens, "Praticiens") ;		
		clPanneaux.show(conteneur, "Accueil");
		this.setResizable(false) ;
		
	}
	
	public ControleurGsb getControleur() {
		return this.controleur;
	}

	public void changerVue(String vue) {
		System.out.println("VueGsb::changerVue()") ;
		clPanneaux.show(conteneur, vue)	;		
	}
	
	public void creerVueRapport(String matricule, int mois, int annee){
		System.out.println("VueGsb::creerVueRapport()") ;
		this.vueRapport = new VueRapport(matricule, mois, annee);
		conteneur.add(this.vueRapport, "Rapport") ;
	}
	
	public JMenuItem getItemQuitter() {
		return itemQuitter;
	}

	public JMenuItem getItemConsulterRapport() {
		return itemConsulterRapport;
	}

	public JMenuItem getItemVisualiserPraticiens() {
		return itemVisualiserPraticiens;
	}

	public JMenuItem getItemAPropos() {
		return itemAPropos;
	}

	public JMenuItem getItemAide() {
		return itemAide;
	}

	public JMenuItem getItemDeconnecter() {
		return itemDeconnecter;
	}
	
	public JMenuItem getItemAccueil() {
		return itemAccueil;
	}

	public void setItemAccueil(JMenuItem itemAccueil) {
		this.itemAccueil = itemAccueil;
	}

	public Delegue getDelegue() {
		return this.delegue;
		
	}
	
	public void setMenusConnecte(){
		System.out.println("VueGsb::setMenusConnecte()") ;

		itemQuitter.setEnabled(true);
		itemDeconnecter.setEnabled(true) ;
		menuFichier.setEnabled(true) ;
		menuRapports.setEnabled(true);
		menuPraticiens.setEnabled(true) ;
		menuAide.setEnabled(true);
	}	

	private void creerBarreMenus(){
		System.out.println("VueGsb::creerBarreMenus()") ;
		JMenuBar barreMenus = new JMenuBar() ;
		itemAccueil.setMnemonic('A');
		itemAccueil.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
		itemDeconnecter.setMnemonic('D');
		itemDeconnecter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
		itemQuitter.setMnemonic('Q');
		itemQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,InputEvent.CTRL_MASK));
		itemQuitter.setToolTipText("Quitter l'application") ;
		
		menuFichier.add(this.itemAccueil) ;
		menuFichier.setMnemonic('F');
		menuFichier.add(this.itemDeconnecter) ;
		menuFichier.addSeparator() ;
		menuFichier.add(this.itemQuitter) ;
		
		menuRapports.setMnemonic('R');
		menuRapports.add(this.itemConsulterRapport) ;
		itemConsulterRapport.setMnemonic('C') ;
		itemConsulterRapport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK));
		
		menuAide.setMnemonic('E');
		menuAide.add(this.itemAPropos) ;
		menuAide.add(this.itemAide) ;
		itemAide.setMnemonic('I') ;
		
		menuPraticiens.setMnemonic('P') ;
		menuPraticiens.add(this.itemVisualiserPraticiens) ;
		itemVisualiserPraticiens.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_MASK));
		
		barreMenus.add(menuFichier) ;
		barreMenus.add(menuRapports) ;
		barreMenus.add(menuPraticiens) ;
		barreMenus.add(menuAide) ;
		
		this.setJMenuBar(barreMenus) ;
		
	}

}