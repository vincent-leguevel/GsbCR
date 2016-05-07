package vues;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import controleurs.ControleurAuthentification;

/** Vue associée au cas d'utilisation "S'authentifier"
 * @author xilim
 *
 */
public class VueAuthentification extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private ControleurAuthentification controleur ;
	
	private JTextField tfLogin = new JTextField("Cadic") ;
	private JPasswordField pfMDP = new JPasswordField("azerty") ;
	private JButton bConnecter = new JButton("Connexion") ;
	private JButton bAnnuler = new JButton("Réinitialiser") ;
	
	/** Contrôleur
	 * @param vueParente La fenêtre principale de l'application
	 */
	public VueAuthentification(){
		super() ;
		System.out.println("VueAuthentification::VueAuthentification()") ;
		this.creerInterfaceUtilisateur();
		this.setTitle("Authentification");
		this.controleur = new ControleurAuthentification(this) ;
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false) ;
		this.setVisible(true) ;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	/** Initialiser les deux champs de saisie avec une chaîne de caractères vide
	 * 
	 */
	public void initialiser(){
		System.out.println("VueAuthentification::initialiser()") ;
		this.tfLogin.setText("") ;
		this.pfMDP.setText("") ;
	}
	
	/** Créer l'interface utilisateur (agencer les composants graphiques)
	 * 
	 */
	private void creerInterfaceUtilisateur(){
		System.out.println("VueAuthentification::creerInterfaceUtilisateur()") ;
		Container conteneur = this.getContentPane() ;
		
		bConnecter.setMnemonic(java.awt.event.KeyEvent.VK_ENTER) ;
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxChamps = Box.createHorizontalBox() ;
		Box boxSaisies = Box.createVerticalBox() ;
		Box boxEtiquettes = Box.createVerticalBox() ;
		Box boxLigne = Box.createHorizontalBox() ;
		Box boxActions = Box.createHorizontalBox() ;
		
		boxEtiquettes.add(new JLabel("Login : ")) ;
		boxEtiquettes.add(new JLabel("MDP : ")) ;
		
		boxSaisies.add(this.tfLogin) ;
		boxSaisies.add(this.pfMDP) ;
		
		boxLigne.add(Box.createHorizontalStrut(5)) ;
		boxLigne.add(new JSeparator()) ;
		boxLigne.add(Box.createHorizontalStrut(5)) ;
		
		boxActions.add(Box.createHorizontalStrut(5)) ;
		boxActions.add(this.bConnecter) ;
		boxActions.add(Box.createHorizontalStrut(5)) ;
		boxActions.add(this.bAnnuler) ;
		boxActions.add(Box.createHorizontalStrut(5)) ;
		
		boxChamps.add(Box.createHorizontalStrut(5)) ;
		boxChamps.add(boxEtiquettes) ;
		boxChamps.add(Box.createHorizontalStrut(5)) ;
		boxChamps.add(boxSaisies) ;
		boxChamps.add(Box.createHorizontalStrut(5)) ;
		
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		boxPrincipale.add(boxChamps) ;
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		boxPrincipale.add(boxLigne) ;
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		boxPrincipale.add(boxActions) ;
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		
		conteneur.add(boxPrincipale) ;
		
		Dimension dimensionBouton = this.bConnecter.getPreferredSize() ;
		
		this.bAnnuler.setPreferredSize(dimensionBouton) ;
		this.bAnnuler.setMaximumSize(dimensionBouton) ;
		this.bAnnuler.setMinimumSize(dimensionBouton) ;
	}

	public JTextField getTfLogin() {
		return tfLogin;
	}

	public JPasswordField getPfMDP() {
		return pfMDP;
	}

	public JButton getbConnecter() {
		return bConnecter;
	}

	public JButton getbAnnuler() {
		return bAnnuler;
	}
	
}
