package vues;

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import controleurs.ControleurDateRapport;

public class VueDateRapport extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> cbMois = new JComboBox<String>() ;
	private JComboBox<Integer> cbAnnee = new JComboBox<Integer>() ;
	private ArrayList<String> mois = new ArrayList<String>();
	private JButton bValider = new JButton("Valider") ;
	private JButton bAnnuler = new JButton("Annuler") ;
	private ControleurDateRapport controleur;
	private VueGsb vue ;
	private JTextField matricule = new JTextField() ;
	private String vis_matricule;
	
	/** Constructeur
	 * @param vue Vue principale de l'application
	 * @param matricule2 
	 */
	public VueDateRapport(VueGsb vue, String matricule) {
		System.out.println("VueNouveauClient::VueNouveauClient()") ;
		this.vue = vue;
		this.vue = vue ;
		this.vis_matricule = matricule;
		this.remplirComboBox();
		this.creerInterfaceUtilisateur();
		
		this.controleur = new ControleurDateRapport(this) ;
		this.setTitle("Choisir la date du rapport");
		this.setSize(200,200) ; 
		this.setModal(true);
		this.setLocationRelativeTo(vue);
		this.pack();
		this.setResizable(false) ;
		this.setVisible(true) ;
	}
	
	private void creerInterfaceUtilisateur(){
		System.out.println("VueNouveauClient::creerInterfaceUtilisateur()") ;	
		
		Container conteneur = this.getContentPane() ;
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxChamps = Box.createHorizontalBox() ;
		Box boxSaisies = Box.createVerticalBox() ;
		Box boxEtiquettes = Box.createVerticalBox() ;
		Box boxLigne = Box.createHorizontalBox() ;
		Box boxActions = Box.createHorizontalBox() ;
		
		boxEtiquettes.add(new JLabel("Matricule :")) ;
		boxEtiquettes.add(Box.createVerticalStrut(12)) ;
		boxEtiquettes.add(new JLabel("Mois : ")) ;
		boxEtiquettes.add(Box.createVerticalStrut(12)) ;
		boxEtiquettes.add(new JLabel("Année : ")) ;
		
		matricule.setText(getVis_matricule());
		matricule.setEditable(false) ;
		boxSaisies.add(this.matricule) ;
		boxSaisies.add(Box.createVerticalStrut(5)) ;
		boxSaisies.add(this.cbMois) ;
		boxSaisies.add(Box.createVerticalStrut(5)) ;
		boxSaisies.add(this.cbAnnee) ;

		boxLigne.add(Box.createHorizontalStrut(5)) ;
		boxLigne.add(new JSeparator()) ;
		boxLigne.add(Box.createHorizontalStrut(5)) ;
		
		boxActions.add(Box.createHorizontalStrut(5)) ;
		boxActions.add(this.bValider) ;
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
		
		Dimension dimensionBouton = this.bAnnuler.getPreferredSize() ;
		
		this.bValider.setPreferredSize(dimensionBouton) ;
		this.bValider.setMaximumSize(dimensionBouton) ;
		this.bValider.setMinimumSize(dimensionBouton) ;
		
		Dimension dimensionBox = this.cbMois.getSize();
		this.cbAnnee.setSize(dimensionBox);
		//this.cbAnnee.setMinimumSize(dimensionBox);		
	}
	
	public String getVis_matricule() {
		return vis_matricule;
	}

	public VueGsb getVue() {
		return vue;
	}

	public void setVue(VueGsb vue) {
		this.vue = vue;
	}

	public JComboBox<String> getCbMois() {
		return cbMois;
	}

	public JComboBox<Integer> getCbAnnee() {
		return cbAnnee;
	}

	public JButton getbValider() {
		return bValider;
	}

	public JButton getbAnnuler() {
		return bAnnuler;
	}
	/** Creer les entrées dans les ComboBox
	 * 
	 */
	
	private void remplirComboBox(){
		for(int i = 2010; i <= 2020; i++){
			this.cbAnnee.addItem(new Integer(i));
		}
		String[] option ={"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
		
		for(String unMois: option){
			cbMois.addItem(unMois);
		}
	}
	

}